package by.gstu.services;

import javax.jws.WebService;

@WebService(name = "MathService")
public class MathServiceImpl implements MathService {
    @Override
    public double sin(double x) {
        return Math.sin(x);
    }
    @Override
    public double cos(double x) {
        return Math.cos(x);
    }
    @Override
    public double exp(double x) {
        return Math.exp(x);
    }
    @Override
    public double log10(double x) {
        return Math.log10(x);
    }
    @Override
    public double log2(double x) {
        return Math.log(x);
    }
}
