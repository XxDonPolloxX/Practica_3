package jerarquicos;

public class ABEnteros<Integer> extends AB{
    public ABEnteros(NodoAB raiz) {
        super(raiz);
    }
    public boolean comprobarSumas(){
        int sumaDer, sumaIzq;
        if(raiz==null){
            return true;
        }
        if(raiz.getDer()==null){
            sumaDer=0;
        }
        else{sumaDer=sumarArboles(raiz.getDer());}
        if(raiz.getIzq()==null){
            sumaIzq=0;
        }
        else{sumaIzq=sumarArboles(raiz.getIzq());}
        if(raiz.getDer()==null && raiz.getIzq()==null){
            return true;
        }
        if(sumaIzq==sumaDer && comprobarSumas(raiz.getDer()) && comprobarSumas(raiz.getIzq())){
            return true;
        }
        else {
            return false;
        }
    }
    private boolean comprobarSumas(NodoAB<Integer> nodo){
        int sumaDer, sumaIzq;
        if(nodo==null){
            return true;
        }
        if(nodo.getDer()==null){
            sumaDer=0;
        }
        else{sumaDer=sumarArboles(nodo.getDer());}
        if(nodo.getIzq()==null){
            sumaIzq=0;
        }
        else{sumaIzq=sumarArboles(nodo.getIzq());}
        if(nodo.getDer()==null && nodo.getIzq()==null){
            return true;
        }
        if(sumaIzq==sumaDer && comprobarSumas(nodo.getDer()) && comprobarSumas(nodo.getIzq())){
            return true;
        }
        else {
            return false;
        }

    }
    public int sumarArboles(NodoAB<Integer> nodo){
        int suma;
        suma= (int) nodo.getDato();
        if(nodo.getIzq()!=null){
            suma+=sumarArboles(nodo.getIzq());
        }
        if(nodo.getDer()!=null){
            suma+=sumarArboles(nodo.getDer());
        }
        return suma;
    }

    public boolean comprobarClavePequenia(){
        if(raiz == null){
            return true;
        }
        return comprobarClavePequenia(raiz);
    }
    private boolean comprobarClavePequenia(NodoAB<Integer> nodo){
        while (nodo != null){
            if (nodo.getIzq() != null) {
                if ((int) nodo.getDato() > (int) nodo.getIzq().getDato()) {
                    return false;
                }
            }
            if (nodo.getDer() != null) {
                if ((int) nodo.getDato() > (int) nodo.getDer().getDato()) {
                    return false;
                }
            }
            if (nodo.getIzq() != null && nodo.getDer() != null) {
                if (comprobarClavePequenia(nodo.getIzq()) && comprobarClavePequenia(nodo.getDer())) {
                    return false;
                }
            }
        }
    }
    public int sumaNodosNiveles(int K1, int K2){
        int suma=0;
        if(esVacio()){
            return 0;
        }
        suma += sumaNodosNiveles(K1, K2, raiz.getDer(), 1);
        suma += sumaNodosNiveles(K1, K2, raiz.getIzq(), 1);
        return suma;
    }
    private int sumaNodosNiveles(int K1, int K2, NodoAB<Integer> nodo, int K){
        int suma=0;
        if(nodo==null){
            return 0;
        }
        if(K>=K1 && K<=K2){
            K++;
            suma = (int)nodo.getDato();
            suma+=sumaNodosNiveles(K1, K2, nodo.getDer(), K) + sumaNodosNiveles(K1, K2, nodo.getIzq(), K);
        }
        return suma;
    }

}
