package com.aluracursos.screenMatch.excepcion;

public class ErrorEnConversionDeDuracionException extends RuntimeException { //No extiende de Throwable sino de RuntimeException, ya que es no checkable

    private String mensaje;

    public ErrorEnConversionDeDuracionException(String mensaje) { //se cambio de nombre por String mensaje

        this.mensaje = mensaje;
    }

    //sobreescribir
    @Override
    public String getMessage() {
        //return super.getMessage(); forma parte de clase madre
        return this.mensaje;  //retorne mensaje
    }
}
