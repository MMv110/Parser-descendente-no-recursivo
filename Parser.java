import java.util.List;
import java.util.Map;
import java.util.Deque;
import java.util.Collections;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Parser {
    private final List<Token> tokens;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public boolean parse(){
        //Se crea la pila y se añade el Q y el fin de cadena.
        Deque<String> pila = new ArrayDeque<String>();
        pila.add("Q");
        pila.add("$");      

        //Se crea la tabla.
        Tabla tab = new Tabla();
        Map<String, Map<TipoToken,List<String>>> tabla = tab.crearTabla();

        //Mientras la pila contenga algo...
        while(pila.size()>0){

            //Se muestran el primero de la pila y el token a analizar.
            System.out.println("--------------------------------");
            String top = pila.getFirst();
            System.out.println(top);
            System.out.println(tokens.get(0).tipo+ " "+tokens.get(0).lexema);

            //Se verifica que sea un termina.
            if(isTerminal(top)){
                tokens.remove(0);
                pila.pop();
            }
            //Si no
            else{

                //Se crea la lista de la producción.
                List<String> produccion = new ArrayList<String>();
                produccion = tabla.get(top).get(tokens.get(0).tipo);
                System.out.println(produccion);

                //Verificamos que se encontró algo en la tabla o botamos error.
                if(produccion == null){
                    Principal.error(0, "hubo un problema en el "+tokens.get(0).tipo);
                    return false;
                }

                //Quitamos el top de la pila para proseguir a la inserción de las producciones
                pila.pop();
                
                // Se revierte la lista para añadir correctamente a la pila.
                List<String> produccionf = new ArrayList<String>(produccion);
                Collections.reverse(produccionf);
                for (String string : produccionf)
                    pila.addFirst(string);   
                }
        }
        return true;
    }

    public boolean isTerminal(String string){

        // Se crea una lista con las palabras reservadas de los terminales.
        List<Token> reservadas = new ArrayList<>();
    
        reservadas.add(new Token(TipoToken.IDENTIFICADOR, "Id"));
        reservadas.add(new Token(TipoToken.SELECT, "select"));
        reservadas.add(new Token(TipoToken.FROM, "from"));
        reservadas.add(new Token(TipoToken.DISTINCT, "distinct"));
        reservadas.add(new Token(TipoToken.COMA, ","));
        reservadas.add(new Token(TipoToken.PUNTO, "."));
        reservadas.add(new Token(TipoToken.ASTERISCO, "*"));
        reservadas.add(new Token(TipoToken.EOF, "$"));

        //Validamos que el terminal enviado coincida con un lexema de las reservadas.
        for (Token token : reservadas)
            if(token.lexema.equalsIgnoreCase(string))
                return true;
            return false;
    }
}

