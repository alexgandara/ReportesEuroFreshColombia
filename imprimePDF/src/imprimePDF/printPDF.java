package imprimePDF;



import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BarcodePDF417;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;



public class printPDF {
	
	
	//private static PdfWriter writer;


	
	public static final String FONT = ".\\resources\\fonts\\Consolas.ttf";
	public static final String FONT_AN = ".\\resources\\fonts\\arial-narrow.ttf";
	// private static String FILE = "c:/temp/FirstPdf.pdf";
	
	public static void imp_factura(String _file_xml, factura_cabecera Cabecera, factura_detalle[] Detalle, int _lineas_de_la_factura, String _file_pdf) throws DocumentException, IOException {
		//String reportePDF = ".\\data\\20525719953\\05_pdfs\\xxx.pdf"; 
		
		
		String reportePDF = _file_pdf;
		 // 
		String formato_factura = ".\\data\\20175077023\\10_formatos\\formatoSFS.jpg"; // .gif and .jpg are ok too!
		
	
        
		 	Document document = new Document();
	        // step 2
	       
	        
	       // Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(reportePDF));
          //  PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(reportePDF));
            
            PdfWriter writer =
    	            PdfWriter.getInstance(document, new FileOutputStream(reportePDF));
            
	        // step 3
	        document.open();
	        
	        BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	        Font console = new Font(bf, 9);
	        
	
			Image img = Image.getInstance(formato_factura);
			img.scalePercent(23);
			img.setAbsolutePosition(0, 60); // horizontal , vertical
			document.add(img);
	       
	        // step 4
	     
	
	        
	         
	        // ruc  emisor
	        PdfContentByte canvas = writer.getDirectContent(); //  getDirectContentUnder();
	        writer.setCompressionLevel(0);

	   
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(440, 768);                         // 36 788 Td
	        //canvas.setFontAndSize(BaseFont.createFont(), 11); // /F1 12 Tf
	        canvas.setFontAndSize(bf, 13);
	        canvas.showText(Cabecera.get_ruc_emisor());	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q
	 
	        
	        
	        // NOMBRE DEL DOCUMENTO
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(435, 750);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 11); // /F1 12 Tf
	        canvas.showText(Cabecera.get_tipo_doc_descripcion());	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q
	  
	        
	        // serie
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(470, 718);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 11); // /F1 12 Tf
	        canvas.showText(Cabecera.get_serie());	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q
	 
	        // folio
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(470, 703);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 11); // /F1 12 Tf
	        canvas.showText(Cabecera.get_folio());	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q
	         
	        
	        // razon social del emisor
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(170, 705);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 11); // /F1 12 Tf
	    //    canvas.showText(Cabecera.get_razon_social_emisor());	        // (Hello World)Tj
	   //     canvas.showText("LA GRAN EMPRESA SAC");	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q
	        
	        // direccion social del emisor
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(170, 690);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 9); // /F1 12 Tf
	    //    canvas.showText(Cabecera.get_direccion_emisor());	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q
	        
	        
	        
	        // ruc del receptor
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(60, 625);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 8); // /F1 12 Tf
	        canvas.showText("RUC:           "+Cabecera.get_ruc_receptor());	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q
	        
	        
	        // RAZON SOCIAL  del receptor
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(60, 610);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 8); // /F1 12 Tf
	        canvas.showText("Razon Social:  "+Cabecera.get_razon_social_receptor());	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q

	        // fecha de emision del docto
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(390, 625);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 8); // /F1 12 Tf
	        canvas.showText("Fecha de Emision: "+Cabecera.get_fecha());	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q


	        //moneda
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(390, 610);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 8); // /F1 12 Tf
	        canvas.showText("Moneda:           "+Cabecera.get_moneda());	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q

	        //IGV
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(390, 595);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 8); // /F1 12 Tf
	        canvas.showText("% IGV:            "+"18 %");	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q

	        
	        
	        
	        // RAZON SOCIAL  del receptor
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(60, 595);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 8); // /F1 12 Tf
	        canvas.showText("Dirección:     "+Cabecera.get_direccion_receptor());	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q
	        
	       
	        
	        // cantidad en letra
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(50, 305);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 8); // /F1 12 Tf
	        canvas.showText("Cantidad en Letra:"+Cabecera.get_total_letra()+" Soles.");	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q
	       
	        
	     // TOTAL subtotal
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(455, 303);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 8); // /F1 12 Tf
	        canvas.showText("Subtotal:"+Formato.dinero(Cabecera.get_subtotal()));
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q
	       
	        // TOTAL subtotal
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(455, 290);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 8); // /F1 12 Tf
	        canvas.showText("IGV:     "+Formato.dinero(Cabecera.get_total_igv()));
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q  
	        
	        // TOTAL DE LA FACTURAS
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(455, 277);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 8); // /F1 12 Tf
	     // canvas.showText("Total:      "+Cabecera.get_total());	        // (Hello World)Tj
	        canvas.showText("Total:   "+Formato.dinero(Cabecera.get_total()));
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q
	       
	        
	        
	        
	     // resumen ha										sh
	        canvas.saveState();                               // q
	        canvas.beginText();                               // BT
	        canvas.moveText(150, 225);                         // 36 788 Td
	        canvas.setFontAndSize(bf, 9); // /F1 12 Tf
	        canvas.showText("...Código Hash:"+Cabecera.get_codigo_hash());	        // (Hello World)Tj
	        canvas.endText();                                 // ET
	        canvas.restoreState();                            // Q
	        
	  	    BarcodePDF417 pdf417 = new BarcodePDF417();
	  	    String text = Cabecera.get_sello();
	  	    
	  	       pdf417.setText(text);
	  	       Image barras = pdf417.getImage(); 
	  	       barras.setAbsolutePosition(66, 90); 
	  	       document.add(barras);
	
	  	       
	  	       
		        //special font sizes
		        BaseFont bf_arial = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		        Font arial = new Font(bf_arial, 7);
		        	      
		  	     Paragraph _linea00 = new Paragraph();
		  	     Chunk _espacio = new Chunk(" ",arial);
		  	     _linea00.add(_espacio);
		  	     
		  	     
		  	     for (int z = 1; z<=17; z++) {
		  	    	 document.add(_linea00);
		  	     }
		  	     
		  	     
		  	     Paragraph _linea01 = new Paragraph(8);
		  	    Cabecera.set_subtotal(0);
		  	    Cabecera.set_total_igv(0);
		  	    Cabecera.set_total(0);
		  	   
		  	     for (int i=0; i<_lineas_de_la_factura; i++) {
		  	    	
		  	    	
		  	    	
		  	    	
		  	    		 
		  	    		 
		  	    		Cabecera.set_subtotal(Cabecera.get_subtotal()+Detalle[i].get_subtotal_sin_igv());
			  	    	 Cabecera.set_total_igv(Cabecera.get_total_igv()+Detalle[i].get_igv());
			  	    	 Cabecera.set_total(Cabecera.get_subtotal()+Cabecera.get_total_igv());
			  	    	 
			  	    	 
		  	    		 Chunk _producto = new Chunk(Formato.padRight(Detalle[i].get_codigo(),17));
		  	    		 Chunk _descripcion = new Chunk(Formato.padRight(Formato.cadena35(Detalle[i].get_descripcion()),43));
		  	    		 Chunk _unidad_de_medida = new Chunk(Formato.cadena5(Detalle[i].get_unidad()));
		  	    		 Chunk _cantidad = new Chunk(Formato.dinero(Detalle[i].get_cantidad()));
		  	    		 Chunk _precio = new Chunk(Formato.dinero(Detalle[i].get_precio_unitario()));
		  	    		 Chunk _importe = new Chunk(Formato.dinero(Detalle[i].get_subtotal()));
		  	    		 Chunk _importe_sin_igv = new Chunk(Formato.dinero(Detalle[i].get_subtotal_sin_igv()));
	  	     
		  	    		 _espacio.setFont(arial);
		  	    		 //  _lineas_de_la_factura
	  	     
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _producto.setFont(arial);
	  	     
		  	    		 _descripcion.setFont(arial);
		  	    		 _unidad_de_medida.setFont(arial);
		  	    		 _cantidad.setFont(arial);
		  	    		 _precio.setFont(arial);
		  	    		 _importe.setFont(arial);
		  	    		 _importe_sin_igv.setFont(arial);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_producto);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_unidad_de_medida);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_cantidad);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		_linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
	  	     
		  	    		 _linea01.add(_descripcion);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 
		  	    		_linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_precio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
	
	  	   
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_espacio);
		  	    		 _linea01.add(_importe_sin_igv);
	  	     
	  	    
	  	    
	  	     
	  	     
		  	    		 document.add(_linea01);
		  	    		 _linea01.removeAll(_linea01);
	
	  	     }
		  	     
		  	     
		  	     
	   	
			      

	        // step 5
	        document.close();		
		
		
		
	}

    	
}

		  	     
		  	     