public class CSV {

    private String zona;
    private String subZona;
    private String year;
    private String aguaSuministrada;
    private String aguaRegistrada;
    private String longitudRedAbastecimiento;
    private String longitudRedRenovada;
    private String renovacionRedAbastecimiento;
    private String edadMediaDistribucion;
    private String numAcometidas;
    private String numAcometidasPorLongitud;
    private String poblacionServidaPorLongitud;
    private String consumoElectricoAbastecimiento;
    private String fugasEnRedTransporte;
    private String fugasEnRedDistribucion;
    private String fugasAcometidas;
    private String escapesRoturasEnAccesoriosRed;
    private String fugasNaturalesRedTransportePor100Km;
    private String fugasNaturalesRedDistribucionPor100Km;
    private String fugasNaturalesAcometidaPor1000Acometidas;
    private String eficienciaDeteccionFugasDistribucion;
    private String rendimientoTecnicoHidraulicoDistribucion;
    private String aguaNoRegistradaPorKmPorDia;
    private String indiceLinealConsumo;

    public CSV() {

    }



    public CSV(String zona, String subZona, String year, String aguaSuministrada, String aguaRegistrada, String longitudRedAbastecimiento, String longitudRedRenovada, String renovacionRedAbastecimiento, String edadMediaDistribucion, String numAcometidas, String numAcometidasPorLongitud, String poblacionServidaPorLongitud, String consumoElectricoAbastecimiento, String fugasEnRedTransporte, String fugasEnRedDistribucion, String fugasAcometidas, String escapesRoturasEnAccesoriosRed, String fugasNaturalesRedTransportePor100Km, String fugasNaturalesRedDistribucionPor100Km, String fugasNaturalesAcometidaPor1000Acometidas, String eficienciaDeteccionFugasDistribucion, String rendimientoTecnicoHidraulicoDistribucion, String aguaNoRegistradaPorKmPorDia, String indiceLinealConsumo) {
        this.zona = zona;
        this.subZona = subZona;
        this.year = year;
        this.aguaSuministrada = aguaSuministrada;
        this.aguaRegistrada = aguaRegistrada;
        this.longitudRedAbastecimiento = longitudRedAbastecimiento;
        this.longitudRedRenovada = longitudRedRenovada;
        this.renovacionRedAbastecimiento = renovacionRedAbastecimiento;
        this.edadMediaDistribucion = edadMediaDistribucion;
        this.numAcometidas = numAcometidas;
        this.numAcometidasPorLongitud = numAcometidasPorLongitud;
        this.poblacionServidaPorLongitud = poblacionServidaPorLongitud;
        this.consumoElectricoAbastecimiento = consumoElectricoAbastecimiento;
        this.fugasEnRedTransporte = fugasEnRedTransporte;
        this.fugasEnRedDistribucion = fugasEnRedDistribucion;
        this.fugasAcometidas = fugasAcometidas;
        this.escapesRoturasEnAccesoriosRed = escapesRoturasEnAccesoriosRed;
        this.fugasNaturalesRedTransportePor100Km = fugasNaturalesRedTransportePor100Km;
        this.fugasNaturalesRedDistribucionPor100Km = fugasNaturalesRedDistribucionPor100Km;
        this.fugasNaturalesAcometidaPor1000Acometidas = fugasNaturalesAcometidaPor1000Acometidas;
        this.eficienciaDeteccionFugasDistribucion = eficienciaDeteccionFugasDistribucion;
        this.rendimientoTecnicoHidraulicoDistribucion = rendimientoTecnicoHidraulicoDistribucion;
        this.aguaNoRegistradaPorKmPorDia = aguaNoRegistradaPorKmPorDia;
        this.indiceLinealConsumo = indiceLinealConsumo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSubZona() {
        return subZona;
    }

    public void setSubZona(String subZona) {
        this.subZona = subZona;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAguaSuministrada() {
        return aguaSuministrada;
    }

    public void setAguaSuministrada(String aguaSuministrada) {
        this.aguaSuministrada = aguaSuministrada;
    }

    public String getAguaRegistrada() {
        return aguaRegistrada;
    }

    public void setAguaRegistrada(String aguaRegistrada) {
        this.aguaRegistrada = aguaRegistrada;
    }

    public String getLongitudRedAbastecimiento() {
        return longitudRedAbastecimiento;
    }

    public void setLongitudRedAbastecimiento(String longitudRedAbastecimiento) {
        this.longitudRedAbastecimiento = longitudRedAbastecimiento;
    }

    public String getLongitudRedRenovada() {
        return longitudRedRenovada;
    }

    public void setLongitudRedRenovada(String longitudRedRenovada) {
        this.longitudRedRenovada = longitudRedRenovada;
    }

    public String getRenovacionRedAbastecimiento() {
        return renovacionRedAbastecimiento;
    }

    public void setRenovacionRedAbastecimiento(String renovacionRedAbastecimiento) {
        this.renovacionRedAbastecimiento = renovacionRedAbastecimiento;
    }

    public String getEdadMediaDistribucion() {
        return edadMediaDistribucion;
    }

    public void setEdadMediaDistribucion(String edadMediaDistribucion) {
        this.edadMediaDistribucion = edadMediaDistribucion;
    }

    public String getNumAcometidas() {
        return numAcometidas;
    }

    public void setNumAcometidas(String numAcometidas) {
        this.numAcometidas = numAcometidas;
    }

    public String getNumAcometidasPorLongitud() {
        return numAcometidasPorLongitud;
    }

    public void setNumAcometidasPorLongitud(String numAcometidasPorLongitud) {
        this.numAcometidasPorLongitud = numAcometidasPorLongitud;
    }

    public String getPoblacionServidaPorLongitud() {
        return poblacionServidaPorLongitud;
    }

    public void setPoblacionServidaPorLongitud(String poblacionServidaPorLongitud) {
        this.poblacionServidaPorLongitud = poblacionServidaPorLongitud;
    }

    public String getConsumoElectricoAbastecimiento() {
        return consumoElectricoAbastecimiento;
    }

    public void setConsumoElectricoAbastecimiento(String consumoElectricoAbastecimiento) {
        this.consumoElectricoAbastecimiento = consumoElectricoAbastecimiento;
    }

    public String getFugasEnRedTransporte() {
        return fugasEnRedTransporte;
    }

    public void setFugasEnRedTransporte(String fugasEnRedTransporte) {
        this.fugasEnRedTransporte = fugasEnRedTransporte;
    }

    public String getFugasEnRedDistribucion() {
        return fugasEnRedDistribucion;
    }

    public void setFugasEnRedDistribucion(String fugasEnRedDistribucion) {
        this.fugasEnRedDistribucion = fugasEnRedDistribucion;
    }

    public String getFugasAcometidas() {
        return fugasAcometidas;
    }

    public void setFugasAcometidas(String fugasAcometidas) {
        this.fugasAcometidas = fugasAcometidas;
    }

    public String getEscapesRoturasEnAccesoriosRed() {
        return escapesRoturasEnAccesoriosRed;
    }

    public void setEscapesRoturasEnAccesoriosRed(String escapesRoturasEnAccesoriosRed) {
        this.escapesRoturasEnAccesoriosRed = escapesRoturasEnAccesoriosRed;
    }

    public String getFugasNaturalesRedTransportePor100Km() {
        return fugasNaturalesRedTransportePor100Km;
    }

    public void setFugasNaturalesRedTransportePor100Km(String fugasNaturalesRedTransportePor100Km) {
        this.fugasNaturalesRedTransportePor100Km = fugasNaturalesRedTransportePor100Km;
    }

    public String getFugasNaturalesRedDistribucionPor100Km() {
        return fugasNaturalesRedDistribucionPor100Km;
    }

    public void setFugasNaturalesRedDistribucionPor100Km(String fugasNaturalesRedDistribucionPor100Km) {
        this.fugasNaturalesRedDistribucionPor100Km = fugasNaturalesRedDistribucionPor100Km;
    }

    public String getFugasNaturalesAcometidaPor1000Acometidas() {
        return fugasNaturalesAcometidaPor1000Acometidas;
    }

    public void setFugasNaturalesAcometidaPor1000Acometidas(String fugasNaturalesAcometidaPor1000Acometidas) {
        this.fugasNaturalesAcometidaPor1000Acometidas = fugasNaturalesAcometidaPor1000Acometidas;
    }

    public String getEficienciaDeteccionFugasDistribucion() {
        return eficienciaDeteccionFugasDistribucion;
    }

    public void setEficienciaDeteccionFugasDistribucion(String eficienciaDeteccionFugasDistribucion) {
        this.eficienciaDeteccionFugasDistribucion = eficienciaDeteccionFugasDistribucion;
    }

    public String getRendimientoTecnicoHidraulicoDistribucion() {
        return rendimientoTecnicoHidraulicoDistribucion;
    }

    public void setRendimientoTecnicoHidraulicoDistribucion(String rendimientoTecnicoHidraulicoDistribucion) {
        this.rendimientoTecnicoHidraulicoDistribucion = rendimientoTecnicoHidraulicoDistribucion;
    }

    public String getAguaNoRegistradaPorKmPorDia() {
        return aguaNoRegistradaPorKmPorDia;
    }

    public void setAguaNoRegistradaPorKmPorDia(String aguaNoRegistradaPorKmPorDia) {
        this.aguaNoRegistradaPorKmPorDia = aguaNoRegistradaPorKmPorDia;
    }

    public String getIndiceLinealConsumo() {
        return indiceLinealConsumo;
    }

    public void setIndiceLinealConsumo(String indiceLinealConsumo) {
        this.indiceLinealConsumo = indiceLinealConsumo;
    }
}
