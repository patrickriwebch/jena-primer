package ch.innovativeweb.jena;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.RIOT;

/**
 *
 */
public class App
{
    public static void main( String[] args )
    {
      File file = new File(args[0]);
      InputStream in = null;

      try {
          in = new FileInputStream(file);
      } catch (IOException e) {
          e.printStackTrace();
          return;
      }

      if (null == in) {
        System.out.println("*** InputStream is null!");
        return;
      }
      RIOT.init() ;

      Model model = ModelFactory.createDefaultModel(); // creates an in-memory Jena Model
      model.read(in, null, "TURTLE"); // parses an InputStream assuming RDF in Turtle format

      // Write the Jena Model in Turtle, RDF/XML and N-Triples format
      /*System.out.println("\n---- Turtle ----");
      model.write(System.out, "TURTLE");
      System.out.println("\n---- RDF/XML ----");
      model.write(System.out, "RDF/XML");
      System.out.println("\n---- RDF/XML Abbreviated ----");
      model.write(System.out, "RDF/XML-ABBREV");*/
      System.out.println("\n---- N-Triples ----");
      model.write(System.out, "N-TRIPLES");
      /*System.out.println("\n---- RDF/JSON ----");
      model.write(System.out, "RDF/JSON");
      System.out.println("\ndone.\n");*/
    }
}
