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
    //un método público donde se elija que tipo de instrucción es
    //y 8 métodos privados que analicen la sentencia.
    //devolver un string con los errores
    public String LeerStatement(String[] A){
        a = A;
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
            CREATErules();    
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
    
    private void CREATErules(){
    }
    
    private void ALTERrules(){
    }
    
    private void DROPrules(){
    }
    
    private void TRUNCATErules(){
    }   
}
