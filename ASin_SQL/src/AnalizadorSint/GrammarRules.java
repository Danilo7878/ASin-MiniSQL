/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSint;

/**
 *
 * @author danil
 */
public class GrammarRules {

    
    String[] a;
    int lookahead;
    //un método público donde se elija que tipo de instrucción es
    //y 8 métodos privados que analicen la sentencia.
    //devolver un string con los errores
    public String LeerStatement(String[] A){
        a = A;
        lookahead = 1;
        String[] ComienzoDeSentencia = A[0].split("|");
        String Error = "";
        switch(ComienzoDeSentencia[0]) {
        //DML
        case "SELECT":
            SELECTrules();
            break;
        case "INSERT":
            INSERTrules();
            break;
        case "UPDATE":
            UPDATErules();
            break;
        case "DELETE":
            DELETErules();
            break;
        case "CREATE":
            Error = CREATErules();    
            break;
        case "ALTER":
            ALTERrules();
            break;
        case "DROP":
            DROPrules();
            break;
        case "TRUNCATE":
            TRUNCATErules();
            break;
        default:
            break;
        }
        return Error;
    }
    
    private void SELECTrules(){
    }
    
    private void INSERTrules(){
    }
    
    private void UPDATErules(){
    }
    
    private void DELETErules(){
    }
    
    private String CREATErules(){
        if (comparar("DATABASE")) {
           if(comparar("Identificador")){
           return "";
           }
           else{
           return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                    + "> en la linea: " + a[lookahead].split("|")[1];
           }
        }else if (comparar("TABLE")) {
            return "";
        }else if (comparar("VIEW")) {
            return "";
        }else if (comparar("LOGIN")) {
            return "";
        }else if (comparar("INDEX")) {
            return "";
        }else{
            return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                    + "> en la linea: " + a[lookahead].split("|")[1];
        }
    }
    
    private void ALTERrules(){
        
    }
    
    private String DROPrules(){
        if (comparar("DATABASE")){
           if(comparar("Identificador")){
               if (comparar(",")) {
                   while(comparar("Identificador")){
                       if (comparar(";")){
                       return "";
                       }else if (comparar("GO")){
                       return "";
                       }else if (comparar(",")){
                       //no hago nada porque es correcto
                       }else{
                       return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                        + "> en la linea: " + a[lookahead].split("|")[1];
                       }
                   }
                   return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                    + "> en la linea: " + a[lookahead].split("|")[1];
               }
               if (comparar(";")) {
               return "";    
               }
               else if (comparar("GO")){
               return "";
               }
               else
               {
               return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                    + "> en la linea: " + a[lookahead].split("|")[1];
               }
            }else if(comparar("IF")){
               if (comparar("EXISTS")){
               if(comparar("Identificador")){
               if (comparar(",")) {
                   while(comparar("Identificador")){
                       if (comparar(";")){
                       return "";
                       }else if (comparar("GO")){
                       return "";
                       }else if (comparar(",")){
                       //no hago nada porque es correcto
                       }else{
                       return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                        + "> en la linea: " + a[lookahead].split("|")[1];
                       }
                   }
                   return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                    + "> en la linea: " + a[lookahead].split("|")[1];
               }
               if (comparar(";")) {
               return "";    
               }
               else if (comparar("GO")){
               return "";
               }
               else
               {
               return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                    + "> en la linea: " + a[lookahead].split("|")[1];
               }
               }
               else{
                return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                 + "> en la linea: " + a[lookahead].split("|")[1];
               }
                }else{
                return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                    + "> en la linea: " + a[lookahead].split("|")[1];
           }
            }else{
            return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                     + "> en la linea: " + a[lookahead].split("|")[1];
            }
        }else if (comparar("TABLE")) {
           if(comparar("Identificador")){
           return "";
           }
           else{
           return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                    + "> en la linea: " + a[lookahead].split("|")[1];
           }
        }else if (comparar("VIEW")) {
            return "";
        }else if (comparar("LOGIN")) {
            return "";
        }else if (comparar("INDEX")) {
            return "";
        }else{
            return "ERROR: no se esperaba un <" + a[lookahead].split("|")[0]
                    + "> en la linea: " + a[lookahead].split("|")[1];
        }
    }
    
    private void TRUNCATErules(){
        
    }    
    
    private boolean comparar(String esperado){
        if (esperado.equals(a[lookahead].split("|")[0])) {
            lookahead++;
            return true;
        }
        else{
            return false;
        }
    }
}
