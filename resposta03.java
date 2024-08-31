/*3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora,
faça um programa, na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados.
Estes dias devem ser ignorados no cálculo da média;*/

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class resposta03 {

    public static void main(String[] args) {
        try {
            // Carregar o arquivo XML
            File xmlFile = new File("faturamento.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);

            // Normalizar o XML
            document.getDocumentElement().normalize();

            // Obter todos os elementos "dia"
            NodeList nodeList = document.getElementsByTagName("dia");

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0.0;
            int diasComFaturamento = 0;

            // Processar os elementos "dia"
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    double valor = Double.parseDouble(element.getTextContent());

                    // Ignorar dias sem faturamento
                    if (valor > 0) {
                        if (valor < menorFaturamento) {
                            menorFaturamento = valor;
                        }
                        if (valor > maiorFaturamento) {
                            maiorFaturamento = valor;
                        }
                        somaFaturamento += valor;
                        diasComFaturamento++;
                    }
                }
            }

            // Calcular a média mensal considerando apenas os dias com faturamento
            double mediaMensal = somaFaturamento / diasComFaturamento;

            // Contar o número de dias com faturamento acima da média
            int diasAcimaDaMedia = 0;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    double valor = Double.parseDouble(element.getTextContent());
                    if (valor > mediaMensal) {
                        diasAcimaDaMedia++;
                    }
                }
            }

            // Exibir os resultados
            System.out.println("Menor faturamento do mês: R$ " + menorFaturamento);
            System.out.println("Maior faturamento do mês: R$ " + maiorFaturamento);
            System.out.println("Número de dias com faturamento acima da média mensal: " + diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
