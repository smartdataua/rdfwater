import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParseCSV {
    private static final String CSV_FILE_PATH = "C:\\Users\\quico\\Desktop\\Google drive\\UNI\\4º\\TFG\\4ª lectura\\your_csv_file_sameAs.csv";
    private static final String AGUA_SUMINISTRADA = "AguaSuministrada";
    private static final String AGUA_REGISTRADA = "AguaRegistrada";
    private static final String LONGITUD_RED_ABASTECIMIENTO = "LongituRedAbastacimiento";
    private static final String LONGITUD_RED_RENOVADA = "LongituRedRenovada";
    private static final String RENOVACION_RED_ABASTECIMIENTO = "RenovacionRedAbastecimiento";
    private static final String EDAD_MEDIA_DISTRIBUCION = "EdadMediaDistribucion";
    private static final String NUM_ACOMETIDAS = "NumAcometidas";
    private static final String NUM_ACOMETIDAS_POR_LONGITUD = "NumAcometidasPorLongitud";
    private static final String POBLACION_SERVIDA_POR_LONGITUD = "PoblacionServidaPorLongitud";
    private static final String CONSUMO_ELECTRICO_ABASTECIMIENTO = "ConsumoElectricoAbastecimiento";
    private static final String FUGAS_EN_RED_TRANSPORTE = "FugasEnRedTransporte";
    private static final String FUGAS_EN_RED_DISTRIBUCION = "FugasEnRedDistribucion";
    private static final String FUGAS_ACOMETIDAS = "FugasAcometidas";
    private static final String ESCAPES_ROTURAS_EN_ACCESORIOS_RED = "EscapesRoturasEnAccesoriosRed";
    private static final String FUGAS_NATURALES_RED_TRANSPORTE_POR_100_KM = "FugasNaturalesRedTransportePor100Km";
    private static final String FUGAS_NATURALES_RED_DISTRIBUCION_POR_100_KM = "FugasNaturalesRedDistribucionPor100Km";
    private static final String FUGAS_NATURALES_ACOMETIDA_POR_1000_ACOMETIDAS = "FugasNaturalesAcometidaPor1000Acometidas";
    private static final String EFICIENCIA_DETECCION_FUGAS_DISTRIBUCION = "EficienciaDeteccionFugasDistribucion";
    private static final String RENDIMIENTO_TECNICO_HIDRAULICO_DISTRIBUCION = "RendimientoTecnicoHidraulicoDistribucion";
    private static final String AGUA_NO_REGISTRADA_POR_KM_POR_DIA = "AguaNoRegistradaPorKmPorDia";
    private static final String INDICE_LINEAL_CONSUMO = "IndiceLinealConsumo";

    public Model createTriples(Model model) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        ) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(CSV.class);
            String[] memberFieldsToBindTo = {"zona", "subZona", "year", "aguaSuministrada", "aguaRegistrada",
            "longitudRedAbastecimiento", "longitudRedRenovada", "renovacionRedAbastecimiento", "edadMediaDistribucion",
            "numAcometidas", "numAcometidasPorLongitud", "poblacionServidaPorLongitud", "consumoElectricoAbastecimiento",
            "fugasEnRedTransporte", "fugasEnRedDistribucion", "fugasAcometidas", "escapesRoturasEnAccesoriosRed",
            "fugasNaturalesRedTransportePor100Km", "fugasNaturalesRedDistribucionPor100Km", "fugasNaturalesAcometidaPor1000Acometidas",
            "eficienciaDeteccionFugasDistribucion", "rendimientoTecnicoHidraulicoDistribucion", "aguaNoRegistradaPorKmPorDia",
            "indiceLinealConsumo"};
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean<CSV> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSV> myRowIterator = csvToBean.iterator();

            while (myRowIterator.hasNext()) {
                CSV csvRow = myRowIterator.next();
                Resource resourceZone;
                String subzone = csvRow.getSubZona();
                if (csvRow.getSubZona().contains("Zona")) {
                    subzone = subzone.substring(csvRow.getSubZona().lastIndexOf(" ") + 1);
                    resourceZone = model.getResource(Tutorial01.baseURI+"zona" + subzone);
                } else {
                    resourceZone = model.getResource(Tutorial01.baseURI+csvRow.getSubZona());
                }

                Resource resource;

                if (!csvRow.getAguaSuministrada().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasAguaSuministradaURI), model.getResource(Tutorial01.baseURI + subzone + AGUA_SUMINISTRADA + csvRow.getYear()));
                    resource = model.getResource(Tutorial01.baseURI + subzone + AGUA_SUMINISTRADA + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getAguaSuministrada());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.m3));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getAguaRegistrada().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasAguaRegistradaURI), model.getResource(Tutorial01.baseURI + subzone + AGUA_REGISTRADA + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + AGUA_REGISTRADA + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getAguaRegistrada());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.m3));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getLongitudRedAbastecimiento().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasLongitudRedAbastecimientoURI), model.getResource(Tutorial01.baseURI + subzone + LONGITUD_RED_ABASTECIMIENTO + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + LONGITUD_RED_ABASTECIMIENTO + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getLongitudRedAbastecimiento());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.km));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getLongitudRedRenovada().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasLongitudRedRenovadaURI), model.getResource(Tutorial01.baseURI + subzone + LONGITUD_RED_RENOVADA + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + LONGITUD_RED_RENOVADA + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getLongitudRedRenovada());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.km));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getRenovacionRedAbastecimiento().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasRenovacionRedAbastecimientoURI), model.getResource(Tutorial01.baseURI + subzone + RENOVACION_RED_ABASTECIMIENTO + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + RENOVACION_RED_ABASTECIMIENTO + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getRenovacionRedAbastecimiento());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.tantoPorCiento));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getEdadMediaDistribucion().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasEdadMediaDistribucionURI), model.getResource(Tutorial01.baseURI + subzone + EDAD_MEDIA_DISTRIBUCION + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + EDAD_MEDIA_DISTRIBUCION + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getEdadMediaDistribucion());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.nAnyos));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getNumAcometidas().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasNumeroDeAcometidasURI), model.getResource(Tutorial01.baseURI + subzone + NUM_ACOMETIDAS + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + NUM_ACOMETIDAS + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getNumAcometidas());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.numero));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getNumAcometidasPorLongitud().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasNumeroDeAcometidasPorLongitudURI), model.getResource(Tutorial01.baseURI + subzone + NUM_ACOMETIDAS_POR_LONGITUD + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + NUM_ACOMETIDAS_POR_LONGITUD + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getNumAcometidasPorLongitud());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.numeroPorKm));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getPoblacionServidaPorLongitud().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasPoblacionServidaPorLongitudRedDistribucionURI), model.getResource(Tutorial01.baseURI + subzone + POBLACION_SERVIDA_POR_LONGITUD + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + POBLACION_SERVIDA_POR_LONGITUD + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getPoblacionServidaPorLongitud());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.numeroPorKm));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getConsumoElectricoAbastecimiento().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasConsumoElectricoAbastecimientoURI), model.getResource(Tutorial01.baseURI + subzone + CONSUMO_ELECTRICO_ABASTECIMIENTO + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + CONSUMO_ELECTRICO_ABASTECIMIENTO + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getConsumoElectricoAbastecimiento());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.kwh));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getFugasEnRedTransporte().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasFugasEnRedDeTransporteURI), model.getResource(Tutorial01.baseURI + subzone + FUGAS_EN_RED_TRANSPORTE + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + FUGAS_EN_RED_TRANSPORTE + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getFugasEnRedTransporte());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.numero));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getFugasEnRedDistribucion().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasFugasEnRedDeDistribucionURI), model.getResource(Tutorial01.baseURI + subzone + FUGAS_EN_RED_DISTRIBUCION + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + FUGAS_EN_RED_DISTRIBUCION + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getFugasEnRedDistribucion());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.numero));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getFugasAcometidas().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasFugasEnAcometidasURI), model.getResource(Tutorial01.baseURI + subzone + FUGAS_ACOMETIDAS + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + FUGAS_ACOMETIDAS + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getFugasAcometidas());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.numero));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getEscapesRoturasEnAccesoriosRed().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasEscapesYRoturasEnAccesoriosDeRedURI), model.getResource(Tutorial01.baseURI + subzone + ESCAPES_ROTURAS_EN_ACCESORIOS_RED + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + ESCAPES_ROTURAS_EN_ACCESORIOS_RED + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getEscapesRoturasEnAccesoriosRed());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.numero));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }

                if (!csvRow.getFugasNaturalesRedTransportePor100Km().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasFugasNaturalesRedDeTransportePor100KmRedURI), model.getResource(Tutorial01.baseURI + subzone + FUGAS_NATURALES_RED_TRANSPORTE_POR_100_KM + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + FUGAS_NATURALES_RED_TRANSPORTE_POR_100_KM + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getFugasNaturalesRedTransportePor100Km());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.numeroPor100Km));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getFugasNaturalesRedDistribucionPor100Km().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasFugasNaturalesRedDeDistribucionPor100KmRedURI), model.getResource(Tutorial01.baseURI + subzone + FUGAS_NATURALES_RED_DISTRIBUCION_POR_100_KM + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + FUGAS_NATURALES_RED_DISTRIBUCION_POR_100_KM + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getFugasNaturalesRedDistribucionPor100Km());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.numeroPor100Km));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getFugasNaturalesAcometidaPor1000Acometidas().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasFugasNaturalesAcometidaPor1000AcometidasURI), model.getResource(Tutorial01.baseURI + subzone + FUGAS_NATURALES_ACOMETIDA_POR_1000_ACOMETIDAS + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + FUGAS_NATURALES_ACOMETIDA_POR_1000_ACOMETIDAS + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getFugasNaturalesAcometidaPor1000Acometidas());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.numeroPor1000acom));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getEficienciaDeteccionFugasDistribucion().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasEficienciaDeteccionDeFugasDistribucionURI), model.getResource(Tutorial01.baseURI + subzone + EFICIENCIA_DETECCION_FUGAS_DISTRIBUCION + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + EFICIENCIA_DETECCION_FUGAS_DISTRIBUCION + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getEficienciaDeteccionFugasDistribucion());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.tantoPorCiento));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getRendimientoTecnicoHidraulicoDistribucion().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasRendimientoTecnicoHidraulicoDistribucionURI), model.getResource(Tutorial01.baseURI + subzone + RENDIMIENTO_TECNICO_HIDRAULICO_DISTRIBUCION + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + RENDIMIENTO_TECNICO_HIDRAULICO_DISTRIBUCION + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getRendimientoTecnicoHidraulicoDistribucion());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.tantoPorCiento));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getAguaNoRegistradaPorKmPorDia().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasAguaNoRegistradaPorKmPorDiaURI), model.getResource(Tutorial01.baseURI + subzone + AGUA_NO_REGISTRADA_POR_KM_POR_DIA + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + AGUA_NO_REGISTRADA_POR_KM_POR_DIA + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getAguaNoRegistradaPorKmPorDia());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.m3PorKmPorDia));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }
                if (!csvRow.getIndiceLinealConsumo().equals("-")) {
                    resourceZone.addProperty(model.getProperty(Tutorial01.hasIndiceLinealDeConsumoURI), model.getResource(Tutorial01.baseURI + subzone + INDICE_LINEAL_CONSUMO + csvRow.getYear()));

                    resource = model.getResource(Tutorial01.baseURI + subzone + INDICE_LINEAL_CONSUMO + csvRow.getYear());
                    resource.addProperty(model.getProperty(Tutorial01.valueURI), csvRow.getIndiceLinealConsumo());
                    resource.addProperty(model.getProperty(Tutorial01.unidadPropURI), model.getResource(Tutorial01.m3PorKmPorDia));
                    resource.addProperty(model.getProperty(Tutorial01.inYearURI), model.getResource(Tutorial01.baseURI + csvRow.getYear()));
                }



            }
        }
        return model;
    }

    public ArrayList<String> getSubzones() throws IOException {
        ArrayList subZones = new ArrayList();
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        ) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(CSV.class);
            String[] memberFieldsToBindTo = {"zona", "subZona"};
            strategy.setColumnMapping(memberFieldsToBindTo);

            CsvToBean<CSV> csvToBean = new CsvToBeanBuilder(reader)
                    .withMappingStrategy(strategy)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSV> myRowIterator = csvToBean.iterator();

            while (myRowIterator.hasNext()) {
                CSV csvRow = myRowIterator.next();
                subZones.add(csvRow.getSubZona().substring(csvRow.getSubZona().lastIndexOf(" ") + 1));
            }
            return subZones;
        }
    }
}
