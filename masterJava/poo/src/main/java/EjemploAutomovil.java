public class EjemploAutomovil {
    public static void main(String[] args) {

        //Instancia de automovil
        Automovil automovil = new Automovil();
        /*automovil.fabricante = "Subaru";
        automovil.modelo = "Impreza";
        automovil.color = "Blanco";
        automovil.cilindrada = 2.0;*/

        //Encapsulamiento:
        automovil.setFabricante("Subaru");
        automovil.setCapacidadEstanque(60);
        automovil.setModelo("Impreza");
        automovil.setColor("Rojo");
        automovil.setCilindrada(2.0);

        Automovil mazda = new Automovil();
        /*mazda.fabricante = "Mazda";
        mazda.modelo = "BT-50";
        mazda.cilindrada = 3.0;
        mazda.color = "Rojo";*/

        //Imprimir
        System.out.println(automovil.verDetalle());
        //System.out.println(mazda.verDetalle());

        System.out.println(automovil.acelerar(3000));
        System.out.println(automovil.frenar());
        //System.out.println(mazda.frenar());

        System.out.println("km por litro: " + automovil.calcularConsumo(300, 0.75F));
        System.out.println("km por litro: " + automovil.calcularConsumo(300, 60));
    }
}
