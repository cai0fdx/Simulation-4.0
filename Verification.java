public class Verification {

    public static void verificarion() throws InterruptedException{

       Sensores sensor = new Sensores();
    
       boolean obj = true; //simulação da verificação das peças
        
       //Condição, se peça está OK
       if (sensor.getSensor1() && sensor.getSensor2() && sensor.getSensor3() && sensor.getSensor4() && sensor.getSensor5()){
        System.out.println("checking objects..\n");
        Thread.sleep(2000);

        if (obj = true){
            System.out.println("object accept");
            Thread.sleep(1000);
        }
        else {
            System.out.println("Object reject");
        }
       }

}
    
}
