public class ListaSimple {
    NodoLista inicio;
    NodoLista ultimo;

    public ListaSimple() {
    }

    public NodoLista getInicio() {
        return inicio;
    }

    public void setInicio(NodoLista inicio) {
        this.inicio = inicio;
    }

    public NodoLista getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoLista ultimo) {
        this.ultimo = ultimo;
    }

    public void addNodoInicio(int dato) {
        NodoLista aux = new NodoLista();
        aux.setInformacion(dato);
        if (inicio == null) {
            inicio = aux;
            ultimo = aux;
        } else {
            aux.setSiguiente(inicio);
            inicio = aux;
        }
    }

    public void addNodoFinal(int dato) {
        NodoLista nodoAux = new NodoLista();
        nodoAux.setInformacion(dato);
        if (inicio == null) inicio = nodoAux;
        else {
            NodoLista aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodoAux);
        }
    }

    public void addNodoFinal2(int dato) {
        NodoLista nodoAux = new NodoLista();
        nodoAux.setInformacion(dato);
        if (inicio == null) {
            inicio = nodoAux;
            ultimo = nodoAux;
        } else {
            ultimo.setSiguiente(nodoAux);
            ultimo = nodoAux;
        }
    }

    public void imprimirLista() {
        NodoLista aux = inicio;
        int i = 0;
        while (aux != null) {
            System.out.println("Nodo #" + (i + 1) + ": " + aux.getInformacion());
            aux = aux.getSiguiente();
            i++;
        }
    }
    public int sizeLista(){
        NodoLista aux = inicio;
        int i = 0;
        while(aux != null){
            aux = aux.getSiguiente();
            i++;
        }
        return i;
    }

    public boolean sonIguales(ListaSimple lista){
        boolean valor = false;
        NodoLista aux = this.inicio;
        NodoLista aux2 = lista.getInicio();
        if(this.sizeLista() == lista.sizeLista()){
            for(int i = 0; i < this.sizeLista(); i++){
                if(aux.getInformacion() == aux2.getInformacion()){
                    aux = aux.getSiguiente();
                    aux2 = aux2.getSiguiente();
                    valor = true;
                }
                else{
                    valor = false;
                    break;
                }
            }
        }
        return valor;
    }

    public boolean Lexicor(ListaSimple A){
        boolean ver = false;
        NodoLista auxiliary1 = new NodoLista();
        NodoLista auxiliary2 = new NodoLista();
        if(this.sizeLista() > A.sizeLista()){
            for(int i = 0; i < A.sizeLista(); i++){
                if(auxiliary1.getInformacion() == auxiliary2.getInformacion()){
                    ver = true;
                }
                else if(auxiliary1.getInformacion() < auxiliary2.getInformacion()){
                    ver = true;
                    break;
                }
                else {
                    ver = false;
                    break;
                }
                auxiliary1 = auxiliary1.getSiguiente();
                auxiliary2 = auxiliary2.getSiguiente();
            }

        }
        else if(this.sizeLista() == A.sizeLista()){
            if(this.sonIguales(A)) {
                ver =  false;
            }
            else{
                for(int i= 0; i < this.sizeLista(); i++){
                    if(auxiliary1.getInformacion() <
                            auxiliary2.getInformacion()){
                        ver = true;
                        break;
                    }
                    else ver = false;

                    auxiliary1 = auxiliary1.getSiguiente();
                    auxiliary2 = auxiliary2.getSiguiente();
                }
            }
        }
        else{
            for(int i = 0; i < this.sizeLista(); i++){
                if(auxiliary1.getInformacion() <
                        auxiliary2.getInformacion()){
                    ver = true;
                    break;
                }
                else ver = false;
            }
            auxiliary1 = auxiliary1.getSiguiente();
            auxiliary2 = auxiliary2.getSiguiente();
        }
    return ver;
    }

    public ListaSimple invertir (){
        ListaSimple list = new ListaSimple();
        NodoLista nodo = this.getInicio();

        for (int i = 0; i< this.sizeLista();i++){
            list.addNodoInicio(nodo.getInformacion());
            nodo = nodo.getSiguiente();
        }
        return list;
    }
    public ListaSimple dividir (int divisor){
        ListaSimple list = new ListaSimple();
        NodoLista nodo = this.inicio;
        for (int i = 0; i<this.sizeLista(); i++){
            if (nodo.getInformacion() < divisor){
                list.addNodoInicio(nodo.getInformacion());
            }else {
                list.addNodoFinal(nodo.getInformacion());
            }
        nodo = nodo.getSiguiente();
        }
        return list;
    }
}