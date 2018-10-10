import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Tutorial01 extends Object {
    // some definitions
    final static String baseURI    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#";
    final static String owl    = "http://www.w3.org/2002/07/owl#";
    final static String wikidata    = "http://www.wikidata.org/entity/";
    final static String geonames    = "http://www.geonames.org/";
    final static String unidadURI    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#Unidad";
    final static String m3    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#m3";
    final static String km    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#km";
    final static String tantoPorCiento    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#tantoPorCiento";
    final static String nAnyos    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#nanyos";
    final static String numero    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#numero";
    final static String numeroPorKm    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#numero/km";
    final static String m3PorKmPorDia    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#m3/km/dia";
    final static String numeroPor100Km    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#numero/100km";
    final static String numeroPor1000acom    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#numero/1000acom";
    final static String kwh    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#kwh";
    final static String unidadPropURI    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#unidad";
    final static String yearURI    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#Anyo";
    final static String inYearURI    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#enElAnyo";
    final static String valueURI    = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#value";
    final static String typeURI     = "http://www.w3.org/1999/02/22-rdf-syntax-ns#type";
    final static String hasAguaSuministradaURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasAguaSuministrada";
    final static String hasAguaRegistradaURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasAguaRegistrada";
    final static String hasAguaNoRegistradaPorKmPorDiaURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasAguaNoRegistrada/Km/dia";
    final static String hasConsumoElectricoAbastecimientoURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasConsumoElectricoAbastecimiento";
    final static String hasEdadMediaDistribucionURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasEdadMediaDistribucion";
    final static String hasEficienciaDeteccionDeFugasDistribucionURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasEficienciaDetecciónDeFugasDistribucion";
    final static String hasEscapesYRoturasEnAccesoriosDeRedURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasEscapesYRoturasEnAccesoriosDeRed";
    final static String hasFugasEnAcometidasURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasFugasEnAcometidas";
    final static String hasFugasEnRedDeDistribucionURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasFugasEnRedDeDistribucion";
    final static String hasFugasEnRedDeTransporteURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasFugasEnRedDeTransporte";
    final static String hasFugasNaturalesAcometidaPor1000AcometidasURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasFugasNaturalesAcometida/1000Acometidas";
    final static String hasFugasNaturalesRedDeDistribucionPor100KmRedURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasFugasNaturalesRedDeDistribucion/100KmRed";
    final static String hasFugasNaturalesRedDeTransportePor100KmRedURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasFugasNaturalesRedDeTransporte/100KmRed";
    final static String hasIndiceLinealDeConsumoURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasIndiceLinealDeConsumo";
    final static String hasLongitudRedAbastecimientoURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasLongitudRedAbastecimiento";
    final static String hasLongitudRedRenovadaURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasLongitudRedRenovada";
    final static String hasNumeroAcometidasPorLongitudRedDistribucionURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasNumeroAcometidasPorLongitudRedDistribucion";
    final static String hasNumeroDeAcometidasURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasNumeroDeAcometidas";
    final static String hasNumeroDeAcometidasPorLongitudURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasNumeroDeAcometidas/LongitudRedDistribucion";
    final static String hasPoblacionServidaPorLongitudRedDistribucionURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasPoblacionServida/LongitudRedDistribucion";
    final static String hasRendimientoTecnicoHidraulicoDistribucionURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasRendimientoTecnicoHidraulicoDistribucion";
    final static String hasRenovacionRedAbastecimientoURI     = "http://www.khaos.es/ontologies/lucentia/ontologies/water.owl#hasRenovacionRedAbastecimiento";

    public static void main (String args[]) throws IOException {
        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        ParseCSV parseCsv = new ParseCSV();
        createSubzonesYearsUnits(model, parseCsv.getSubzones());
        parseCsv.createTriples(model);
        Tutorial01 sample = new Tutorial01();
        sample.writeRDF(model, "EjemploSameAs");

    }

    public void writeRDF(Model model, String fileName) throws IOException{
        FileWriter out = new FileWriter("./out/" + fileName + ".nt" );
        try {
            model.write( out, "N-TRIPLES" ); //TTL, "RDF/XML-ABBREV"
        }
        finally {
            try {
                out.close();
            }
            catch (IOException closeException) {
                // ignore
            }
        }
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    static void createSubzonesYearsUnits(Model model, ArrayList<String> subzones) {
        Property typeProp = model.createProperty(typeURI);
        Property sameAsProp = model.createProperty(owl+"sameAs");//Remove for not same as

        //Instancias subzonas
        for (String subzone : subzones) {

            if (isInteger(subzone.substring(0,1))) {
                Resource resource = model.createResource(baseURI + "zona" + subzone);
                resource.addProperty(typeProp, model.getResource(baseURI + "Zona" + subzone));
            } else { //remove for not having localities
                Resource resource = model.createResource(baseURI + subzone);
                resource.addProperty(typeProp, model.getResource(baseURI + "Municipio"));
                if (subzone.equals("Agost")) {
                    resource.addProperty(sameAsProp, model.getResource(wikidata + "Q1228383"));
                    resource.addProperty(sameAsProp, model.getResource(geonames + "2522419/agost.html"));

                } else {
                    resource.addProperty(sameAsProp, model.getResource(wikidata + "Q935589"));
                    resource.addProperty(sameAsProp, model.getResource(geonames + "6355512/villajoyosa.html"));
                }
            }

        }

        //Instancias medidas

        Resource resourceKm = model.createResource(baseURI + "km");
        resourceKm.addProperty(typeProp, model.getResource(unidadURI));

        Resource resourceKwh = model.createResource(baseURI + "kwh");
        resourceKwh.addProperty(typeProp, model.getResource(unidadURI));

        Resource resourceM3 = model.createResource(baseURI + "m3");
        resourceM3.addProperty(typeProp, model.getResource(unidadURI));

        Resource resourceM3KmDia = model.createResource(baseURI + "m3/km/dia");
        resourceM3KmDia.addProperty(typeProp, model.getResource(unidadURI));

        Resource resourceNanyos = model.createResource(baseURI + "nanyos");
        resourceNanyos.addProperty(typeProp, model.getResource(unidadURI));

        Resource resourceNumero = model.createResource(baseURI + "numero");
        resourceNumero.addProperty(typeProp, model.getResource(unidadURI));

        Resource Numero1000Acom = model.createResource(baseURI + "numero/1000acom");
        Numero1000Acom.addProperty(typeProp, model.getResource(unidadURI));

        Resource resourceNumero100Km = model.createResource(baseURI + "numero/100km");
        resourceNumero100Km.addProperty(typeProp, model.getResource(unidadURI));

        Resource resourceNumeroKm = model.createResource(baseURI + "numero/km");
        resourceNumeroKm.addProperty(typeProp, model.getResource(unidadURI));

        Resource resourceTantoPorCiento = model.createResource(baseURI + "tantoPorCiento");
        resourceTantoPorCiento.addProperty(typeProp, model.getResource(unidadURI));

        for (int year = 2008 ; year <= 2014 ; year++) {
            Resource resourceYear = model.createResource(baseURI + Integer.toString(year));
            resourceYear.addProperty(typeProp, model.getResource(yearURI));
        }


    }
}
