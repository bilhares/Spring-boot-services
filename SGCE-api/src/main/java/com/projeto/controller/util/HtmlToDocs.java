package com.projeto.controller.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.commons.io.FileUtils;
import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.NumberingDefinitionsPart;


public class HtmlToDocs {

	public static void main(String[] args) throws Exception {
 // TODO Auto-generated method stub

 // File file = new File("C:\\TestWordToHtml\\html\\Test.html");
		
 String inputfilepath = "C:\\temp\\html\\Teste2.html";

 
 StringBuilder html = new StringBuilder();
	html.append("<html>");
	html.append("<head>");

	html.append("<style type=\"text/css\">");
	// css
	html.append("table, th, td { border: 1px solid black; border-collapse: collapse; } th, td { padding: 5px; text-align: left; } body{font-family: \"Verdana\", serif; font-size: 11.25px;  line-height: 150%;}");

	html.append("</style>");
	html.append("</head><body>");

	html.append("<div><p style=\"text-align: center;\">PORTARIA DETRAN-MS \"T\" N.233, DE 14 de Novembro de 2017</p><p style=\"text-align: right;\">\"Aplica a penalidade aos "
			+ "condutores abaixo<br/> mencionados e da outras providencias\".</p><p style=\"text-indent:40px\">O Diretor-Presidente do departamento estadual de transito de Mato Grosso do Sul � DETRAN-MS, "
			+ "no uso de suas atribuicoes legais,<br/> e CONSIDERANDO o que consta nos referidos autos deste departamento estadual de transito;<br/> RESOLVE:<br/> Art. 1 - Aplicar a penalidade"
			+ " que menciona aos condutores abaixo mencionados:</p></div><br/>"
			+ "<table ><tr><th colspan= \"2\">Condutor:</th><td colspan= \"2\">TESTE 0</td></tr><tr><th colspan= \"1\">Cnh:</th><td colspan= \"1\">115724180 MS</td><th colspan= \"1\">Regitro pgu:</th><td colspan=\"1\">04352889020</td></tr><tr><th>Penalidade:</th><td colspan= \"4\">TIPO DO PROCESSO TIPO DO PROCESSO TIPO DO PROCESSO</td></tr><tr><th>Fundamento legal<br/> (artigo do CTB):</th><td>EEVVMAAN22</td><th>Processo:</th><td>006155/20150</td></tr><tr><th>Prazo:</th><td>02 MESES</td><th>Pontuacao:</th><td>007</td></tr></table>"
			+ "<br/><p> Art. 2 - Esta portaria entrara em vigor na data da sua publicacao. Campo Grande (MS) 14 de Novembro de 2017 ROBERTO HASHIOKA SOLER Diretor-Presidente</p>");
	
	html.append("</body>");
	html.append("</html>");

	String arquivo = "";
	String nomeArquivo = "analise-defesa";

//		arquivo = inputfilepath;
//		BufferedWriter htmlFile = new BufferedWriter(new FileWriter(arquivo));
//		htmlFile.write(html.toString());
//		System.out.println("criou o arquivo");
//		
//				
//		htmlFile.close();
//		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		Writer w = new OutputStreamWriter(baos);
		
		w.write(html.toString());
		w.close();
		baos.close();
		
		byte[] bytes = baos.toByteArray();
		
		FileUtils.writeByteArrayToFile(new File("c:/temp/file-test.html"), bytes);
		
		InputStream input =  new ByteArrayInputStream(bytes);
 try {

     WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
             .createPackage();

     NumberingDefinitionsPart ndp = new NumberingDefinitionsPart();
     wordMLPackage.getMainDocumentPart().addTargetPart(ndp);
     ndp.unmarshalDefaultNumbering();

     XHTMLImporterImpl xHTMLImporter = new XHTMLImporterImpl(
             wordMLPackage);
     xHTMLImporter.setHyperlinkStyle("Hyperlink");
     wordMLPackage.getMainDocumentPart().getContent().addAll(
             //xHTMLImporter.convert(new File(inputfilepath), null));
     xHTMLImporter.convert(input, null));

//     File output = new java.io.File(System.getProperty("user.dir")
//             + "/html_output.docx");
     
     ByteArrayOutputStream out = new ByteArrayOutputStream();
     
     wordMLPackage.save(out);
     
     byte[] data = out.toByteArray();
     FileUtils.writeByteArrayToFile(new File("c:/temp/outro.docx"), data);
     System.out.println("done");

//     System.out.println("file path where it is stored is" + " "
//             + output.getAbsolutePath());

 }

 catch (InvalidFormatException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
 }

}}
