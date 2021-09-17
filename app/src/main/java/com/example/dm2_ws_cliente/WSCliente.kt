package com.example.dm2_ws_cliente

import android.os.StrictMode
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.SoapEnvelope
import org.ksoap2.transport.HttpTransportSE


class WSCliente {

    @Throws(IOException::class, XmlPullParserException::class)
    fun dataHora(): String? {

        val policy =
            StrictMode.ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)

        val soap = SoapObject(
            "http://ws/",
            "dt_hora"
        )
        // SOAP OBJECT
        // namespace é o que está no targetnamespace do WSDL
        // name é o nome da operação (método) que irá executar

        // Parâmetros que o webservice recebe
        //soap.addProperty("nome", nome)

        // Usado 1.1 (VER11) no Glassfish
        // Tomcat - VER10
        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER10)

        envelope.setOutputSoapObject(soap)

        val transmitir = HttpTransportSE(
            "http://10.0.2.2:8080/dm2ws2/ServicoApp?wsdl"
        )

        transmitir.call("dt_hora", envelope)

        // Pego o resultado da execução do webservice
        val resultado = envelope.response

        return resultado.toString()
    }

}