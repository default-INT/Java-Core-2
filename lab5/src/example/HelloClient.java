package example;

import by.gstu.services.MathService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:9000/HelloService?wsdl");

        // Параметры следующего конструктора смотрим в самом первом теге WSDL описания - definitions
        // 1-ый аргумент смотрим в атрибуте targetNamespace
        // 2-ой аргумент смотрим в атрибуте name
        QName qname = new QName("http://services.gstu.by/", "MathServiceImplService");

        // Теперь мы можем дотянуться до тега service в wsdl описании
        Service service = Service.create(url, qname);
        // а далее и до вложенного в него тега port, чтобы
        // получить ссылку на удаленный от нас объект веб-сервиса
        MathService mathService = service.getPort(MathService.class);

        System.out.println(mathService.sin(3.14));
    }
}
