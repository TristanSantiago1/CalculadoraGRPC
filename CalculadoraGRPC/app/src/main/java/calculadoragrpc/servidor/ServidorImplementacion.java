package calculadoragrpc.servidor;

import com.proto.calcualdora.Calculadora.ParametrosCalculadora;
import com.proto.calcualdora.Calculadora.ResultadoOperacion;
import com.proto.calcualdora.OperarcionAritmeticaGrpc;

import io.grpc.stub.StreamObserver;

public class ServidorImplementacion extends OperarcionAritmeticaGrpc.OperarcionAritmeticaImplBase{

    @Override
    public void sumar(ParametrosCalculadora parametros, StreamObserver<ResultadoOperacion> resposnObserver){
        int numero1 = Integer.parseInt( parametros.getNumero1());
        int numero2 = Integer.parseInt(parametros.getNumero2());        
        ResultadoOperacion respuesta = ResultadoOperacion.newBuilder().setResultado(String.valueOf( numero1 + numero2)).build();
        resposnObserver.onNext(respuesta);
        resposnObserver.onCompleted();        
    }

    @Override
    public void restar(ParametrosCalculadora parametros, StreamObserver<ResultadoOperacion> resposnObserver){
        int numero1 = Integer.parseInt( parametros.getNumero1());
        int numero2 = Integer.parseInt(parametros.getNumero2());        
        ResultadoOperacion respuesta = ResultadoOperacion.newBuilder().setResultado(String.valueOf( numero1 - numero2)).build();
        resposnObserver.onNext(respuesta);
        resposnObserver.onCompleted();        
    }
    @Override
    public void multiplicar(ParametrosCalculadora parametros, StreamObserver<ResultadoOperacion> resposnObserver){
        int numero1 = Integer.parseInt( parametros.getNumero1());
        int numero2 = Integer.parseInt(parametros.getNumero2());        
        ResultadoOperacion respuesta = ResultadoOperacion.newBuilder().setResultado(String.valueOf( numero1 * numero2)).build();
        resposnObserver.onNext(respuesta);
        resposnObserver.onCompleted();        
    }
    @Override
    public void dividir(ParametrosCalculadora parametros, StreamObserver<ResultadoOperacion> resposnObserver){
        int numero1 = Integer.parseInt( parametros.getNumero1());
        int numero2 = Integer.parseInt(parametros.getNumero2());        
        ResultadoOperacion respuesta = ResultadoOperacion.newBuilder().setResultado(String.valueOf( numero1 / numero2)).build();
        resposnObserver.onNext(respuesta);
        resposnObserver.onCompleted();        
    }
}
