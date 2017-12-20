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

import com.projeto.model.ProcDiarioOficial;


public class HtmlToDocs {

	public static void main(String[] args) throws Exception {
 // TODO Auto-generated method stub

 // File file = new File("C:\\TestWordToHtml\\html\\Test.html");
		
 String inputfilepath = "C:\\temp\\html\\Teste2.html";
ProcDiarioOficial processo = new ProcDiarioOficial();
 
 StringBuilder html = new StringBuilder();
	html.append("<html>");
	html.append("<head>");

	html.append("<style type=\"text/css\">");
	// css
	html.append("table, th, td { border: 1px solid black; border-collapse: collapse; } th, td { padding: 5px; text-align: left; } body{font-family: \"Verdana\", serif; font-size: 11.25px;  line-height: 150%;}");

	html.append("</style>");
	html.append("</head><body>");
	
	//cabeçalho
	html.append("<div >");
	
	html.append("<p style=\"text-align: center;\">PORTARIA DETRAN-MS \"T\" N."+processo.getNumeroProcesso()+", DE "+DataUtil.dataAtualExtenso()+"</p>");
	html.append("<p style=\"text-align: right;\">Aplica a penalidade aos condutores abaixo<br/> mencionados e da outras providencias.</p>");
	html.append("<p style=\"text-indent:40px\">O Diretor-Presidente do departamento estadual de transito de Mato Grosso do Sul DETRAN-MS,no uso de suas atribuicoes\r\n" + 
			"      legais,\r\n" + 
			"      <br/> e CONSIDERANDO o que consta nos referidos autos deste departamento estadual de transito;\r\n" + 
			"      <br/> RESOLVE:\r\n" + 
			"      <br/> Art. 1 - Aplicar a penalidade que menciona aos condutores abaixo mencionados:</p>");
	
	
	html.append("</div>");
	html.append("<br/>");
	
	//tabela
	html.append("<table align=\"center\">");
	//linha1
	html.append("<tr>\r\n" + 
			"      <th colspan=\"2\">Condutor:</th>\r\n" + 
			"      <td colspan=\"2\">"+ processo.getCondutor() +"</td>\r\n" + 
			"    </tr>");
	//lina2
	
	html.append("<tr>\r\n" + 
			"      <th colspan=\"1\">Cnh:</th>\r\n" + 
			"      <td colspan=\"1\">"+processo.getCnh()+"</td>\r\n" + 
			"      <th colspan=\"1\">Regitro pgu:</th>\r\n" + 
			"      <td colspan=\"1\">}"+processo.getRegistroPgu()+"</td>\r\n" + 
			"    </tr>");
	//linha3
	html.append("<tr>\r\n" + 
			"      <th>Penalidade:</th>\r\n" + 
			"      <td colspan=\"4\">"+processo.getTipoProcesso()+"</td>\r\n" + 
			"    </tr>");
	//linha4
	html.append("<tr>\r\n" + 
			"      <th>Fundamento legal\r\n" + 
			"        <br/> (artigo do CTB):</th>\r\n" + 
			"      <td>"+processo.getFundamentoLegal()+"</td>\r\n" + 
			"      <th>Processo:</th>\r\n" + 
			"      <td>"+processo.getNumeroProcesso()+"</td>\r\n" + 
			"    </tr>");
	//linha5
	html.append("<tr>\r\n" + 
			"      <th>Prazo:</th>\r\n" + 
			"      <td>"+processo.getPrazo()+"</td>\r\n" + 
			"      <th>Pontuacao:</th>\r\n" + 
			"      <td>"+processo.getnPontos()+"</td>\r\n" + 
			"    </tr>");
	
	html.append("</table>");
	html.append("<br/>");
	
	
	//rodapé
	html.append("<p> Art. 2 - Esta portaria entrara em vigor na data da sua publicacao. Campo Grande (MS) 14 de Novembro de 2017 ROBERTO HASHIOKA\r\n" + 
			"    SOLER Diretor-Presidente</p>");
	
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
