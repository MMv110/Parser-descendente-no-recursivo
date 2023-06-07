
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class Tabla {
    
    public Map<String, Map<TipoToken, List<String>>> LL1 = new HashMap<>();
    
    public Map<String, Map<TipoToken, List<String>>> crearTabla(){
        
        Map<TipoToken, List<String>> LL1_2 = new HashMap<>();
        List<String> lista = new ArrayList<>();
        lista.add("SELECT");
        lista.add("D");
        lista.add("FROM");
        lista.add("T");
        LL1_2.put( TipoToken.SELECT, lista);
        lista = new ArrayList<>();
        LL1_2.put( TipoToken.EOF, lista);
        LL1.put("Q", LL1_2);
 
        LL1_2 = new HashMap<>();
        lista = new ArrayList<>();
        lista.add("DISTINCT");
        lista.add("P");
        LL1_2.put( TipoToken.DISTINCT, lista);
        lista = new ArrayList<>();
        lista.add("P");
        LL1_2.put( TipoToken.ASTERISCO, lista);
        LL1_2.put(TipoToken.IDENTIFICADOR, lista);
        LL1.put("D", LL1_2);
        
        LL1_2 = new HashMap<>();
        lista = new ArrayList<>();
        lista.add("*");
        LL1_2.put(TipoToken.ASTERISCO, lista);
        lista = new ArrayList<>();
        lista.add("A");
        LL1_2.put(TipoToken.IDENTIFICADOR, lista);
        LL1.put("P", LL1_2);

        LL1_2 = new HashMap<>();
        lista = new ArrayList<>();
        lista.add("A2");
        lista.add("A1");
        LL1_2.put(TipoToken.IDENTIFICADOR, lista);
        LL1.put("A", LL1_2);

        LL1_2 = new HashMap<>();
        lista = new ArrayList<>();
        lista.add(",");
        lista.add("A");
        LL1_2.put(TipoToken.COMA, lista);
        lista = new ArrayList<>();
        LL1_2.put(TipoToken.FROM, lista);   
        LL1.put("A1", LL1_2);

        LL1_2 = new HashMap<>();
        lista = new ArrayList<>();
        lista.add("Id");
        lista.add("A3");
        LL1_2.put(TipoToken.IDENTIFICADOR, lista);   
        LL1.put("A2", LL1_2);
        
        LL1_2 = new HashMap<>();
        lista = new ArrayList<>();
        lista.add(".");
        lista.add("Id");
        LL1_2.put(TipoToken.PUNTO, lista);
        lista = new ArrayList<>();
        LL1_2.put(TipoToken.COMA, lista);
        LL1_2.put(TipoToken.FROM,lista);
        LL1.put("A3", LL1_2);
        
        LL1_2 = new HashMap<>();
        lista = new ArrayList<>();
        lista.add("T2");
        lista.add("T1");
        LL1_2.put(TipoToken.IDENTIFICADOR, lista);
        LL1.put("T", LL1_2);
        
        LL1_2 = new HashMap<>();
        lista = new ArrayList<>();
        lista.add(",");
        lista.add("T");
        LL1_2.put(TipoToken.COMA, lista);
        lista = new ArrayList<>();
        LL1_2.put(TipoToken.EOF, lista);
        LL1.put("T1", LL1_2);
        
        LL1_2 = new HashMap<>();
        lista = new ArrayList<>();
        lista.add("Id");
        lista.add("T3");
        LL1_2.put(TipoToken.IDENTIFICADOR, lista);
        LL1.put("T2", LL1_2);
        
        LL1_2 = new HashMap<>();
        lista = new ArrayList<>();
        lista.add("Id");
        LL1_2.put(TipoToken.IDENTIFICADOR,lista);
        lista = new ArrayList<>();
        LL1_2.put(TipoToken.EOF, lista);
        lista = new ArrayList<>();
        LL1_2.put(TipoToken.COMA, lista);
        LL1.put("T3", LL1_2);

        return LL1;
    }
    
    
}
