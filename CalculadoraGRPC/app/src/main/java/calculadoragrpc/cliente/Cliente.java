package calculadoragrpc.cliente;

import javax.swing.JOptionPane;

import com.proto.calcualdora.OperarcionAritmeticaGrpc;
import com.proto.calcualdora.Calculadora.ParametrosCalculadora;
import com.proto.calcualdora.Calculadora.ResultadoOperacion;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Cliente {
    public static void main(String[] args) {
        
        String host = "localhost";
        int PUERTO = 9000;
    
        ManagedChannel ch = ManagedChannelBuilder.forAddress(host, PUERTO).usePlaintext().build();    
        OperarcionAritmeticaGrpc.OperarcionAritmeticaBlockingStub stub = OperarcionAritmeticaGrpc.newBlockingStub(ch);

        
        while(true){
            String opt = JOptionPane.showInputDialog(
                "Calcular\n"+
                    "Suma -> 1\n" +
                    "Resta -> 2\n" +
                    "Multiplicación -> 3\n" +
                    "División -> 4\n\n" +
                    "Cancelar para salir\n"                         
            );
            if(opt == null){
                break;
            }

            int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el primer numero"));
            int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Segundo numero"));
            ParametrosCalculadora peticion = ParametrosCalculadora.newBuilder().setNumero1(String.valueOf(numero1)).setNumero2(String.valueOf(numero2)).build();
            ResultadoOperacion resultado;
            switch (opt) {
                case "1":
                    resultado = stub.sumar(peticion);
                    JOptionPane.showMessageDialog(null,"Respuesta RPC : " + numero1+"+"+numero2+" = " + resultado.getResultado());
                    break;
                case "2":
                    resultado = stub.restar(peticion);
                    JOptionPane.showMessageDialog(null,"Respuesta RPC : " + numero1+"-"+numero2+" = " + resultado.getResultado());
                    break;
                case "3":
                    resultado = stub.multiplicar(peticion);
                    JOptionPane.showMessageDialog(null,"Respuesta RPC : " + numero1+"*"+numero2+" = " + resultado.getResultado());
                    break;
                case "4":
                    resultado = stub.dividir(peticion);
                    JOptionPane.showMessageDialog(null,"Respuesta RPC : " + numero1+"/"+numero2+" = " + resultado.getResultado());
                    break;
                default:
                    break;
            }
        }        
        System.out.println("Apagando");    
        ch.shutdown();
    
        }
}
