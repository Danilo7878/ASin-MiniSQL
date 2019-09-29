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
        String[] ComienzoDeSentencia = A[0].split("\\|");
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
        //DDL
        case "CREATE":
            Error = CREATErules();    
            break;
        case "ALTER":
            ALTERrules();
            break;
        case "DROP":
            Error = DROPrules();
            break;
        case "TRUNCATE":
            Error = TRUNCATErules();
            break;
        default:
            Error= MensajeError();
            break;
        }
        return Error;
    }
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------    
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------    
    private void SELECTrules(){
    }
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------    
    private void INSERTrules(){
    }
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------    
    private void UPDATErules(){
    }
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------    
    private void DELETErules(){
    }
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------    
    private String CREATErules(){
//--------------------------------------------------------------------------------------------------------------------------------
        if (comparar("DATABASE")) {
           if(comparar("Identificador")){
           return "";
           }
           else{
           return "ERROR: no se esperaba un <" + a[lookahead].split("\\|")[0]
                    + "> en la linea: " + a[lookahead].split("\\|")[1];
           }
//--------------------------------------------------------------------------------------------------------------------------------
        }else if (comparar("TABLE")) {
            return "";
//--------------------------------------------------------------------------------------------------------------------------------
        }else if (comparar("VIEW")) {
            return "";
//--------------------------------------------------------------------------------------------------------------------------------
        }else if (comparar("LOGIN")) {
            return "";
//--------------------------------------------------------------------------------------------------------------------------------
        }else if (comparar("INDEX")) {
            return "";
//--------------------------------------------------------------------------------------------------------------------------------
        }else{
            return MensajeError();
        }
    }
 //--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------   
    private void ALTERrules(){
        
    }
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------TERMINADO---------------------------------------------------------------------------------------------------    
    private String DROPrules(){
        //DROP DATABASE
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
                           return MensajeError();
                       }
                   }
                   return MensajeError();
               }
               if (comparar(";")) {
                   return "";    
               }
               else if (comparar("GO")){
                   return "";
               }
               else
               {
                   return MensajeError();
               }
            }else if(comparar("IF")){
               if (comparar("EXISTS")){
                while(comparar("Identificador")){
                    if (comparar(";")){
                        return "";
                    }else if (comparar("GO")){
                        return "";
                    }else if (comparar(",")){
                        //no hago nada porque es correcto
                    }else{
                        return MensajeError();
                    }
                }
                    return MensajeError();
             }else{
                return MensajeError();
              }
            }else{
                return MensajeError();
            }
//--------------------------------------------------------------------------------------------------------------------------------           
           //DROP TABLE
        }else if (comparar("TABLE")) {
            if (comparar("IF")) {
                if (comparar("EXISTS")) {
                    while(comparar("Identificador")){
                        if (comparar(".")) {
                            if (comparar("Identificador")) {
                                if (comparar(".")) {
                                     if (comparar("Identificador")) {
                                        if (comparar(",")) {
                                         //déjelo correr 
                                         }else if (comparar(";")) {
                                            return "";
                                         }else if (comparar("GO")) {
                                            return "";
                                         }else{
                                            return MensajeError();
                                         }
                                     }else{
                                         return MensajeError();
                                     }
                            }else if (comparar(",")) {
                           //déjelo correr 
                            }else if (comparar(";")) {
                               return "";
                            }else if (comparar("GO")) {
                               return "";
                            }else{
                               return MensajeError();
                            }
                        }
                        }
                        else if (comparar(",")) {
                           //déjelo correr 
                        }else if (comparar(";")) {
                            return "";
                        }else if (comparar("GO")) {
                            return "";
                        }else{
                            return MensajeError();
                        }
                    }
                    return MensajeError();
                }else{
                    return MensajeError();
                }
            }else{
            while(comparar("Identificador")){
                if (comparar(".")) {
                    if (comparar("Identificador")) {
                        if (comparar(".")) {
                             if (comparar("Identificador")) {
                                if (comparar(",")) {
                                 //déjelo correr 
                                 }else if (comparar(";")) {
                                    return "";
                                 }else if (comparar("GO")) {
                                    return "";
                                 }else{
                                    return MensajeError();
                                 }
                             }else{
                                return MensajeError();
                             }
                    }else if (comparar(",")) {
                   //déjelo correr 
                    }else if (comparar(";")) {
                       return "";
                    }else if (comparar("GO")) {
                       return "";
                    }else{
                       return MensajeError();
                    }
                }
                }
                else if (comparar(",")) {
                   //déjelo correr 
                }else if (comparar(";")) {
                    return "";
                }else if (comparar("GO")) {
                    return "";
                }else{
                    return MensajeError();
                }
            }
            return MensajeError();
        }            

//--------------------------------------------------------------------------------------------------------------------------------
           //DROP VIEW
        }else if (comparar("VIEW")) {
            if (comparar("IF")) {
                if (comparar("EXISTS")) {
                    while(comparar("Identificador")){
                        if (comparar(".")) {
                             if (comparar("Identificador")) {
                                if (comparar(",")) {
                                 //déjelo correr 
                                 }else if (comparar(";")) {
                                    return "";
                                 }else if (comparar("GO")) {
                                    return "";
                                 }else{
                                     return MensajeError();
                                 }
                             }else{
                                return MensajeError();
                             }
                        }else if (comparar(",")) {
                       //déjelo correr 
                        }else if (comparar(";")) {
                           return "";
                        }else if (comparar("GO")) {
                           return "";
                        }else{
                             return MensajeError();
                        }                    
                    }
                    return MensajeError();
                }else{
                    return MensajeError();
                }
            }else{
            while(comparar("Identificador")){
                if (comparar(".")) {
                     if (comparar("Identificador")) {
                        if (comparar(",")) {
                         //déjelo correr 
                         }else if (comparar(";")) {
                            return "";
                         }else if (comparar("GO")) {
                            return "";
                         }else{
                             return MensajeError();
                         }
                     }else{
                        return MensajeError();
                     }
            }else if (comparar(",")) {
           //déjelo correr 
            }else if (comparar(";")) {
               return "";
            }else if (comparar("GO")) {
               return "";
            }else{
                 return MensajeError();
            }
        }
            return MensajeError();
        }
//--------------------------------------------------------------------------------------------------------------------------------            
          //DROP LOGIN
        }else if (comparar("LOGIN")) {
            if (comparar("Identificador")) {
                if (comparar(";")) {
                    return "";
                }else if (comparar("GO")) {
                    return "";
                }else{
                    return MensajeError();
                }                
            }else{
                return MensajeError();
            }
//--------------------------------------------------------------------------------------------------------------------------------            
            //DROP INDEX
        }else if (comparar("INDEX")) {
            boolean SeRepiteON = false;
            boolean SeRepitePUNTO = false;
            if (comparar("IF")) {
                if (comparar("EXISTS")) {
                    if (comparar("Identificador")) {                        
                        if (comparar(".")) {
                            if (comparar("Identificador")) {
                                if (comparar(".")) {
                                    if (comparar("Identificador")) {
                                        if (comparar(";")) {
                                            return "";
                                        }else if (comparar("GO")) {
                                            return "";
                                        }else if (comparar(",")) {
                                            SeRepitePUNTO = true;
                                        }else{
                                            return MensajeError();
                                        }
                                    }else{
                                        return MensajeError();
                                    }
                                }else if (comparar(";")) {
                                    return "";
                                }else if (comparar("GO")) {
                                    return "";
                                }else if (comparar(",")) {
                                    SeRepitePUNTO = true;
                                }
                            }else{
                                MensajeError();
                            }
                        }else if (comparar("ON")) {
                            if (comparar("Identificador")) {
                                if (comparar(".")) {
                                    if (comparar("Identificador")) {
                                        if (comparar(".")) {
                                            if (comparar("Identificador")) {
                                                if (comparar(";")) {
                                                    return "";
                                                }else if (comparar("GO")) {
                                                    return "";
                                                }else if (comparar(",")){
                                                    SeRepiteON = true;
                                                }
                                            } else{
                                                return MensajeError();
                                            }
                                        } else if (comparar(";")) {
                                            return "";
                                        }else if (comparar("GO")) {
                                            return "";
                                        }else if (comparar(",")){
                                            SeRepiteON = true;
                                        }
                                    }else{
                                        return MensajeError(); 
                                    }
                                }else if (comparar(";")) {
                                    return "";
                                }else if (comparar("GO")) {
                                    return "";
                                }else if (comparar(",")){
                                    SeRepiteON =true;
                                }
                            }else{
                                return MensajeError();
                            }
                        }else{
                            return MensajeError();
                        }
                    }else{
                        return MensajeError();
                    }
                }else{
                    return MensajeError();
                }
            }else{
            if (comparar("Identificador")) {
                    if (comparar(".")) {
                        if (comparar("Identificador")) {
                            if (comparar(".")) {
                                if (comparar("Identificador")) {
                                    if (comparar(";")) {
                                        return "";
                                    }else if (comparar("GO")) {
                                        return "";
                                    }else if (comparar(",")) {
                                        SeRepitePUNTO = true;
                                    }else{
                                        return MensajeError();
                                    }
                                }else{
                                    return MensajeError();
                                }
                            }else if (comparar(";")) {
                                return "";
                            }else if (comparar("GO")) {
                                return "";
                            }else if (comparar(",")) {
                                SeRepitePUNTO = true;
                            }
                        }else{
                            MensajeError();
                        }
                    }else if (comparar("ON")) {
                        if (comparar("Identificador")) {
                            if (comparar(".")) {
                                if (comparar("Identificador")) {
                                    if (comparar(".")) {
                                        if (comparar("Identificador")) {
                                            if (comparar(";")) {
                                                return "";
                                            }else if (comparar("GO")) {
                                                return "";
                                            }else if (comparar(",")){
                                                SeRepiteON = true;
                                            }
                                        } else{
                                            return MensajeError();
                                        }
                                    } else if (comparar(";")) {
                                        return "";
                                    }else if (comparar("GO")) {
                                        return "";
                                    }else if (comparar(",")){
                                        SeRepiteON = true;
                                    }
                                }else{
                                    return MensajeError(); 
                                }
                            }else if (comparar(";")) {
                                return "";
                            }else if (comparar("GO")) {
                                return "";
                            }else if (comparar(",")){
                                SeRepiteON =true;
                            }
                        }else{
                            return MensajeError();
                        }
                    }else{
                        return MensajeError();
                    }
                }else{
                    return MensajeError();
                }
            }
            if (SeRepitePUNTO) {
                while(comparar("Identificador")){
                    if (comparar(".")){
                        if (comparar("Identificador")) {
                            if (comparar(".")) {
                                if (comparar("Identificador")) {
                                    if (comparar(";")) {
                                        return "";
                                    }else if (comparar("GO")) {
                                        return "";
                                    }else if (comparar(",")) {
                                        //que siga
                                    }else{
                                        return MensajeError();
                                    }
                                }else{
                                    return MensajeError();
                                }
                            }else if (comparar(";")) {
                                return "";
                            }else if (comparar("GO")) {
                                return "";
                            }else if (comparar(",")) {
                                //que siga
                            }else{
                                return MensajeError();
                            }
                        }else{
                            return MensajeError();
                        }
                    }else{
                        return MensajeError();
                    }
                }
                return MensajeError();
            }else if (SeRepiteON) {
                while(comparar("Identificador")){
                    if (comparar("ON")) {
                        if (comparar("Identificador")) {
                            if (comparar(".")) {
                                if (comparar("Identificador")) {
                                    if (comparar(".")) {
                                        if (comparar("Identificador")) {
                                            if (comparar(";")) {
                                                return "";
                                            }else if (comparar("GO")) {
                                                return "";
                                            }else if (comparar(",")){
                                                //que siga
                                            }
                                        } else{
                                            return MensajeError();
                                        }
                                    } else if (comparar(";")) {
                                        return "";
                                    }else if (comparar("GO")) {
                                        return "";
                                    }else if (comparar(",")){
                                        //que siga
                                    }
                                }else{
                                    return MensajeError(); 
                                }
                            }else if (comparar(";")) {
                                return "";
                            }else if (comparar("GO")) {
                                return "";
                            }else if (comparar(",")){
                                //que siga
                            }
                        }else{
                            return MensajeError();
                        }
                    }else{
                        return MensajeError();
                    }
                }
                return MensajeError();
            }else{
                return MensajeError();
            }
//--------------------------------------------------------------------------------------------------------------------------------
        }else{
            return MensajeError();
        }
    }
    
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//------------------------------TERMINADO-----------------------------------------------------------------------------------------  
    private String TRUNCATErules(){
        if (comparar("TABLE")) {
            if (comparar("Identificador")) {
                if (comparar(".")) {
                    if (comparar("Identificador")) {
                        if (comparar(".")) {
                            if (comparar("Identificador")) {
                                if (comparar(";")) {
                                    return "";
                                }else if (comparar("GO")) {
                                    return "";
                                }else{
                                    return MensajeError();
                                }
                            }else{
                                return MensajeError();
                            }
                        }else if (comparar(";")) {
                            return "";
                        }else if (comparar("GO")) {
                            return "";
                        }else{
                            return MensajeError();
                        }
                    } else{
                        return MensajeError();
                    }
                }else if (comparar(";")) {
                    return "";
                }else if (comparar("GO")) {
                    return "";
                }else{
                    return MensajeError();
                }
            }else{
                return MensajeError();
            }
        }else{
            return MensajeError();
        }
    }    
    
    private boolean comparar(String esperado){
        if (esperado.equals(a[lookahead].split("\\|")[0])) {
            lookahead++;
            return true;
        }
        else{
            return false;
        }
    }
    private String MensajeError(){
    return "ERROR: no se esperaba un <" + a[lookahead].split("\\|")[0]
                        + "> en la linea: " + a[lookahead].split("\\|")[1];
    }
}
