package by.gstu.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface MathService {
    @WebMethod
    public double sin(double x);
    @WebMethod
    public double cos(double x);
    @WebMethod
    public double exp(double x);
    @WebMethod
    public double log10(double x);
    @WebMethod
    public double log2(double x);
}
