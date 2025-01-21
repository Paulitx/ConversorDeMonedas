public class ConvertirMoneda {

    public  Double convertirMoneda(Double monedaInicial, Double monedaFinal, Double cant){
        if(cant < 0.0){
            throw new IllegalArgumentException("El valor de la cantidad de monedas no puede ser negativo");
        }
        return (cant/monedaInicial)*monedaFinal;
    }
}
