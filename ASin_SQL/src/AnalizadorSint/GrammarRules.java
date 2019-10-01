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
        String Error;
        switch(ComienzoDeSentencia[0]) {
        //DML
        case "SELECT":
            Error= SELECTrules();
            break;
        case "INSERT":
            Error = INSERTrules();
            break;
        case "UPDATE":
            Error=UPDATErules();
            break;
        case "DELETE":
            Error=DELETErules();
            break;
        //DDL
        case "CREATE":
            Error = CREATErules();    
            break;
        case "ALTER":
            Error = ALTERrules();
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
    private String SELECTrules(){
        comparar("ALL");
        comparar("DISTINCT");
        if (comparar("TOP")) {
            if (comparar("(")) {
                if (comparar("Identificador")) {
                    if (comparar(")")) {
                        comparar("PERCENT");
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else{return MensajeError();}
        }
        if (comparar("*")) {
            //correcto
        }else if (comparar("Identificador")) {
            if (comparar(".")) {
                if (comparar("Identificador")) {
                    if (comparar(".")) {
                        if (comparar("Identificador")) {
                            //correcto
                        }else{return MensajeError();}
                    }
                }else if (comparar("*")) {
                    //correcto 
                }else{return MensajeError();}
            }
        }else if (comparar("COUNT")) {
            if (comparar("(")) {
                if (comparar("*")||comparar("Int")||comparar("Bit")) {
                    if (comparar(")")) {
                        if (comparar("AS")) {
                            if (comparar("Identificador")) {
                                //correcto
                            }else{return MensajeError();}
                        }
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else {return MensajeError();}
        }else if (comparar("MAX")||comparar("MIN")) {
            if (comparar("(")) {
                if (comparar("Identificador")) {
                    if (comparar(".")) {
                        if (comparar("Identificador")) {
                            if (comparar(")")) {
                                if (comparar("AS")) {
                                    if (comparar("Identificador")) {
                                        //correcto
                                    }else{return MensajeError();}
                                }
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }else if (comparar(")")) {
                        if (comparar("AS")) {
                            if (comparar("Identificador")) {
                                //correcto
                            }else{return MensajeError();}
                        }
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else{return MensajeError();}
        }else if (comparar("AVG")||comparar("SUM")) {
            if (comparar("(")) {
                if (comparar("Identificador")) {
                    if (comparar(".")) {
                        if (comparar("Identificador")) {
                            if (comparar(")")) {
                                if (comparar("AS")) {
                                    if (comparar("Identificador")) {
                                        //correcto
                                    }else{return MensajeError();}
                                }
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }else if (comparar(")")) {
                        if (comparar("AS")) {
                            if (comparar("Identificador")) {
                                //correcto
                            }else{return MensajeError();}
                        }
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else{return MensajeError();}
        }else{return MensajeError();}
        while (comparar(",")) {
            if (comparar("*")) {
                //correcto
            }
            else if (comparar("Identificador")) {
                if (comparar(".")) {
                    if (comparar("Identificador")) {
                        if (comparar(".")) {
                            if (comparar("Identificador")) {
                                //correcto
                            }else{return MensajeError();}
                        }
                    }else if (comparar("*")) {
                        //correcto 
                    }else{return MensajeError();}
                }
            }else if (comparar("COUNT")) {
                if (comparar("(")) {
                    if (comparar("*")||comparar("Int")||comparar("Bit")) {
                        if (comparar(")")) {
                            if (comparar("AS")) {
                                if (comparar("Identificador")) {
                                    //correcto
                                }else{return MensajeError();}
                            }
                        }else{return MensajeError();}
                    }else{return MensajeError();}
                }else {return MensajeError();}
            }else if (comparar("MAX")||comparar("MIN")) {
                if (comparar("(")) {
                    if (comparar("Identificador")) {
                        if (comparar(".")) {
                            if (comparar("Identificador")) {
                                if (comparar(")")) {
                                    if (comparar("AS")) {
                                        if (comparar("Identificador")) {
                                            //correcto
                                        }else{return MensajeError();}
                                    }
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else if (comparar(")")) {
                            if (comparar("AS")) {
                                if (comparar("Identificador")) {
                                    //correcto
                                }else{return MensajeError();}
                            }
                        }else{return MensajeError();}
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else if (comparar("AVG")||comparar("SUM")) {
                if (comparar("(")) {
                    if (comparar("Identificador")) {
                        if (comparar(".")) {
                            if (comparar("Identificador")) {
                                if (comparar(")")) {
                                    if (comparar("AS")) {
                                        if (comparar("Identificador")) {
                                            //correcto
                                        }else{return MensajeError();}
                                    }
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else if (comparar(")")) {
                            if (comparar("AS")) {
                                if (comparar("Identificador")) {
                                    //correcto
                                }else{return MensajeError();}
                            }
                        }else{return MensajeError();}
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else{return MensajeError();}
        }
        if (comparar("FROM")) {
            if (comparar("Identificador")) {
                if (comparar(".")) {
                    if (comparar("Identificador")) {
                        if (comparar(".")) {
                            if (comparar("Identificador")) {
                                if (comparar(";")) {
                                    return "";
                                }else if (comparar("GO")) {
                                    return ""; 
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else if (comparar(";")) {
                            return "";
                        }else if (comparar("GO")) {
                           return ""; 
                        }else{return MensajeError();}
                    }else{return MensajeError();}
                }else if (comparar(";")) {
                    return "";
                }else if (comparar("GO")) {
                   return ""; 
                }else{return MensajeError();}
            }else{return MensajeError();}
        }else{return MensajeError();}
    }    
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//-----------TERMINADO------------------------------------------------------------------------------------------------------------    
    private String INSERTrules(){
        if (comparar("TOP")) {
            if (comparar("(")) {
                if (comparar("Int")) {
                    if (comparar(")")) {
                       //correcto, que siga 
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else{return MensajeError();}
        }
        comparar("INTO");
        if (comparar("Identificador")) {
            if (comparar(".")) {
                if (comparar("Identificador")) {
                    if (comparar(".")) {
                        if (comparar("Identificador")) {
                            if (comparar(".")) {
                                if (comparar("Identificador")) {
                                    //que siga
                                }else{return MensajeError();}
                            }else{} 
                        }else{return MensajeError();}
                    }else{}
                }else{return MensajeError();}
            }else{/*que siga*/}
            //lista de columnas pueden o no venir
            if (comparar("(")) {
                while(comparar("Identificador")){
                    comparar(",");
                }
                if (comparar(")")) {
                    //dele viaje
                }else{return MensajeError();}
            }
            if (comparar("VALUES")) {
                while(comparar("(")){
                    while(true){
                        if (comparar("DEFAULT")) {
                            if (comparar(")")) {
                                break;
                            }else if (comparar(",")) {
                                //continua el ciclo
                            }else{return MensajeError();}
                        }else if (comparar("NULL")) {
                            if (comparar(")")) {
                                break;
                            }else if (comparar(",")) {
                                //continua el ciclo
                            }else{return MensajeError();}
                        }else if (comparar("Int")) {
                            if (comparar(")")) {
                                break;
                            }else if (comparar(",")) {
                                //continua el ciclo
                            }else{return MensajeError();}
                        }else if (comparar("String")) {
                            if (comparar(")")) {
                                break;
                            }else if (comparar(",")) {
                                //continua el ciclo
                            }else{return MensajeError();}
                        }else if (comparar("Float")) {
                            if (comparar(")")) {
                                break;
                            }else if (comparar(",")) {
                                //continua el ciclo
                            }else{return MensajeError();}
                        }else if (comparar("Bit")) {
                            if (comparar(")")) {
                                break;
                            }else if (comparar(",")) {
                                //continua el ciclo
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }
                    if (comparar(",")) {
                        //continua el ciclo
                    }else{break;}
                }
                if (comparar(";")) {
                    return "";
                }else if (comparar("GO")) {
                    return "";
                }else{return MensajeError();}
            }else if (comparar("SELECT")) {
                return SELECTrules();
            }else if (comparar("DEFAULT")) {
                if (comparar("VALUES")) {
                    if (comparar(";")) {
                        return "";
                    }else if (comparar("GO")) {
                        return "";
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else{return MensajeError();}
        }else if (comparar("OPENQUERY")) {
            if (comparar("(")) {
                if (comparar("Identificador")) {
                    if (comparar(",")) {
                        if (comparar("String")) {
                            if (comparar(")")) {
                                //correcto que siga
                            }else{return MensajeError();}  
                        }else{return MensajeError();}
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else{return MensajeError();}
            //lista de columnas
            if (comparar("(")) {
                while(comparar("Identificador")){
                    comparar(",");
                }
                if (comparar(")")) {
                    //dele viaje
                }else{return MensajeError();}
            }
            if (comparar("VALUES")) {
                while(comparar("(")){
                    while(true){
                        if (comparar("DEFAULT")) {
                            if (comparar(")")) {
                                break;
                            }else if (comparar(",")) {
                                //continua el ciclo
                            }else{return MensajeError();}
                        }else if (comparar("NULL")) {
                            if (comparar(")")) {
                                break;
                            }else if (comparar(",")) {
                                //continua el ciclo
                            }else{return MensajeError();}
                        }else if (comparar("Int")) {
                            if (comparar(")")) {
                                break;
                            }else if (comparar(",")) {
                                //continua el ciclo
                            }else{return MensajeError();}
                        }else if (comparar("String")) {
                            if (comparar(")")) {
                                break;
                            }else if (comparar(",")) {
                                //continua el ciclo
                            }else{return MensajeError();}
                        }else if (comparar("Float")) {
                            if (comparar(")")) {
                                break;
                            }else if (comparar(",")) {
                                //continua el ciclo
                            }else{return MensajeError();}
                        }else if (comparar("Bit")) {
                            if (comparar(")")) {
                                break;
                            }else if (comparar(",")) {
                                //continua el ciclo
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }
                    if (comparar(",")) {
                        //continua el ciclo
                    }else{break;}
                }
                if (comparar(";")) {
                    return "";
                }else if (comparar("GO")) {
                    return "";
                }else{return MensajeError();}
            }else if (comparar("SELECT")) {
                return SELECTrules();
            }else if (comparar("DEFAULT")) {
                if (comparar("VALUES")) {
                    if (comparar(";")) {
                        return "";
                    }else if (comparar("GO")) {
                        return "";
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else{return MensajeError();}
        } else{return MensajeError();}
    }
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------    
    private String UPDATErules(){
        return "";
    }
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------    
    private String DELETErules(){
        return "";
    }
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//-------------TERMINADO----------------------------------------------------------------------------------------------------------    
    private String CREATErules(){
//--------------------------------------------------------------------------------------------------------------------------------
        if (comparar("DATABASE")) {
           if(comparar("Identificador")){
               if (comparar("COLLATE")) {
                   if (comparar("Identificador")) {
                       if (comparar(";")) {
                           return "";
                       }else if (comparar("GO")) {
                           return "";
                       }else{return MensajeError();}
                   }else{return MensajeError();}
               }else if (comparar(";")) {
                   return "";
               }else if (comparar("GO")) {
                   return "";
               }else{return MensajeError();}
           }else{return MensajeError();}
//--------------------------------------------------------------------------------------------------------------------------------
        }else if (comparar("UNIQUE")) {
            if (comparar("CLUSTERED")) {
                if (comparar("INDEX")) {
                    return GenericINDEXrulesForCREATE();
                }else{return MensajeError();}
            }else if (comparar("NONCLUSTERED")) {
                if (comparar("INDEX")) {
                    return GenericINDEXrulesForCREATE();
                }else{return MensajeError();}
            }else if (comparar("INDEX")) {
                return GenericINDEXrulesForCREATE();
            }else{return MensajeError();}
        }else if (comparar("CLUSTERED")) {
            if (comparar("INDEX")) {
                return GenericINDEXrulesForCREATE();
            }else{return MensajeError();}
        }else if (comparar("NONCLUSTERED")) {
            if (comparar("INDEX")) {
                return GenericINDEXrulesForCREATE();
            }else{return MensajeError();}
        }else if (comparar("INDEX")) {
            return GenericINDEXrulesForCREATE();
//--------------------------------------------------------------------------------------------------------------------------------            
        }else if (comparar("TABLE")) {
            if (comparar("Identificador")) {
                //PUEDE VENIR O NO (por eso no tiene un else)
                if (comparar(".")) {
                    if (comparar("Identificador")) {
                        if (comparar(".")){
                            if (comparar("Identificador")) {
                                //corecto, que siga
                            }else{return MensajeError();}
                        }else{/*correcto, que siga*/}                        
                    }else{return MensajeError();}
                }
                //PUEDE VENIR O NO (por eso no tiene un else)
                if (comparar("AS")) {
                    if (comparar("Identificador")) {
                        //correcto que siga
                    }else{return MensajeError();}
                }
                
                if (comparar("(")) {
                    while(comparar("Identificador")) {
                        if (comparar("Identificador")) {
                            //puede o no venir
                            if (comparar(".")) {
                                if (comparar("Identificador")) {
                                    //correcto
                                }else{return MensajeError();}
                            }
                            //puede o no venir
                            if (comparar("(")) {
                                if (comparar("Int")|| comparar("Bit")) {
                                    if (comparar(",")) {
                                        if (comparar("Int")|| comparar("Bit")) {
                                            if (comparar(")")) {
                                                //correcto
                                            }else return MensajeError();
                                        }else{return MensajeError();}
                                    }else if (comparar(")")) {
                                        //correcto
                                    }else {return MensajeError();} 
                                }else if (comparar("Identificador")) {
                                    if (comparar(")")) {
                                        //correcto
                                    }else {return MensajeError();}
                                }else{return MensajeError();}
                            }
                            if (comparar("COLLATE")) {
                                if (comparar("Identificador")) {
                                    //correcto
                                }else{return MensajeError();}
                            }
                            if (comparar("CONSTRAINT")) {
                                if (comparar("Identificador")) {
                                    if (comparar("DEFAULT")) {
                                        if (comparar("Int")) {
                                            //correcto
                                        }else if (comparar("String")) {
                                            //correcto
                                        }else if (comparar("Float")) {
                                            //correcto
                                        }else if (comparar("Bit")) {
                                            //correcto
                                        }else{return MensajeError();}
                                    }
                                }else{return MensajeError();}
                            }
                            if (comparar("IDENTITY")) {
                                if (comparar("(")) {
                                    if (comparar("Int") || comparar("Bit")) {
                                        if (comparar(",")) {
                                            if (comparar("Int") || comparar("Bit")) {
                                                if (comparar(")")) {
                                                    //correcto
                                                }else{return MensajeError();}
                                            }else{return MensajeError();}
                                        }else{return MensajeError();}
                                    }else{return MensajeError();}
                                }
                                if (comparar("NOT")) {
                                    if (comparar("FOR")) {
                                        if (!comparar("REPLICATION")) {
                                            return MensajeError();
                                        }
                                    }else if (comparar("NULL")) {
                                        //que siga
                                    }else{return MensajeError();}
                                }
                                comparar("NULL");
                                comparar("ROWGUIDCOL");
                                if (comparar(",")) {
                                    if (comparar("PRIMARY")) {
                                        if (comparar("KEY")){
                                            comparar("CLUSTERED");
                                            comparar("NONCLUSTERED");
                                            if (comparar("ON")) {
                                                if (comparar("Identificador")) {
                                                    if (comparar("(")) {
                                                        if (comparar("Identificador")) {
                                                            if(!comparar(")")){
                                                                return MensajeError();
                                                            }
                                                        }else{return MensajeError();}
                                                    }else{return MensajeError();}
                                                }else if (comparar("PRIMARY")) {
                                                    //siga
                                                }else{return MensajeError();}
                                            }
                                        }else{return MensajeError();}
                                    }else if (comparar("UNIQUE")) {
                                        comparar("CLUSTERED");
                                            comparar("NONCLUSTERED");
                                            if (comparar("ON")) {
                                                if (comparar("Identificador")) {
                                                    if (comparar("(")) {
                                                        if (comparar("Identificador")) {
                                                            if(!comparar(")")){
                                                                return MensajeError();
                                                            }
                                                        }else{return MensajeError();}
                                                    }else{return MensajeError();}
                                                }else if (comparar("PRIMARY")) {
                                                    //siga
                                                }else{return MensajeError();}
                                            }
                                    }else if (comparar("FOREIGN")) {
                                        if (comparar("KEY")){
                                            if (comparar("REFERENCES")) {
                                            return "";
                                            }
                                        }else{return MensajeError();}
                                    }else if (comparar("REFERENCES")) {
                                        return "";
                                    } else if (comparar("CONSTRAINT")) {
                                        if (comparar("Identificador")) {
                                            if (comparar("PRIMARY")) {
                                                if (comparar("KEY")){
                                                    comparar("CLUSTERED");
                                                    comparar("NONCLUSTERED");
                                                    if (comparar("ON")) {
                                                        if (comparar("Identificador")) {
                                                            if (comparar("(")) {
                                                                if (comparar("Identificador")) {
                                                                    if(!comparar(")")){
                                                                        return MensajeError();
                                                                    }
                                                                }else{return MensajeError();}
                                                            }else{return MensajeError();}
                                                        }else if (comparar("PRIMARY")) {
                                                            //siga
                                                        }else{return MensajeError();}
                                                    }
                                                }else{return MensajeError();}
                                            }else if (comparar("UNIQUE")) {
                                                comparar("CLUSTERED");
                                                    comparar("NONCLUSTERED");
                                                    if (comparar("ON")) {
                                                        if (comparar("Identificador")) {
                                                            if (comparar("(")) {
                                                                if (comparar("Identificador")) {
                                                                    if(!comparar(")")){
                                                                        return MensajeError();
                                                                    }
                                                                }else{return MensajeError();}
                                                            }else{return MensajeError();}
                                                        }else if (comparar("PRIMARY")) {
                                                            //siga
                                                        }else{return MensajeError();}
                                                    }
                                            }else if (comparar("FOREIGN")) {
                                                if (comparar("KEY")){
                                                    if (comparar("REFERENCES")) {
                                                    return "";
                                                    }
                                                }else{return MensajeError();}
                                            }else if (comparar("REFERENCES")) {
                                                return "";
                                            }                                              
                                                }else{return MensajeError();}
                                            }
                                        }else if(comparar(")")){
                                            break;
                                        }else{return MensajeError();}
                                    }
                                    
                        }else{return MensajeError();}
                            if (comparar("NOT")) {
                                if (comparar("FOR")) {
                                    if (!comparar("REPLICATION")) {
                                        return MensajeError();
                                    }
                                }else if (comparar("NULL")) {
                                    if (comparar(",")) {
                                        //correcto
                                    }else if (comparar(")")) {
                                        break;
                                    }else {return MensajeError();}
                                }else{return MensajeError();}
                            }else if (comparar("NULL")) {
                                if (comparar(",")) {
                                    //correcto
                                }else if (comparar(")")) {
                                    break;
                                }else{return MensajeError();}
                        }
                    }                    
                }else{return MensajeError();}
                //PUEDE VENIR O NO
                if (comparar("CONSTRAINT")) {
                    if (comparar("Identificador")) {
                        if (comparar("PRIMARY")) {
                            if (comparar("KEY")){
                                comparar("CLUSTERED");
                                comparar("NONCLUSTERED");
                                if (comparar("(")) {
                                    while(comparar("Identificador")){
                                        if (comparar("ASC")||comparar("DESC")) {
                                            if (comparar(",")) {
                                            //continue
                                            }else if (comparar(")")) {
                                                break;
                                            }else{return MensajeError();}
                                        }else if (comparar(",")) {
                                            //continue
                                        }else if (comparar(")")) {
                                            break;
                                        }else{return MensajeError();}
                                    }
                                }
                                }else{return MensajeError();}
                                if (comparar("ON")) {
                                    if (comparar("Identificador")) {
                                        if (comparar("(")) {
                                            if (comparar("Identificador")) {
                                                if(!comparar(")")){
                                                    return MensajeError();
                                                }
                                            }else{return MensajeError();}
                                        }else{return MensajeError();}
                                    }else if (comparar("PRIMARY")) {
                                        //siga
                                    }else{return MensajeError();}                                                               
                            }else{return MensajeError();}
                        }else if (comparar("UNIQUE")) {
                            comparar("CLUSTERED");
                                comparar("NONCLUSTERED");
                                if (comparar("ON")) {
                                    if (comparar("Identificador")) {
                                        if (comparar("(")) {
                                            if (comparar("Identificador")) {
                                                if(!comparar(")")){
                                                    return MensajeError();
                                                }
                                            }else{return MensajeError();}
                                        }else{return MensajeError();}
                                    }else if (comparar("PRIMARY")) {
                                        //siga
                                    }else{return MensajeError();}
                                }
                        }else if (comparar("FOREIGN")) {
                            if (comparar("KEY")){
                                if (comparar("REFERENCES")) {
                                return "";
                                }
                            }else{return MensajeError();}
                        }else if (comparar("REFERENCES")) {
                            return "";
                        }                               
                            }else{return MensajeError();}
                            
                        }
                        if (comparar(")")) {
                                //correcto
                            }else{return MensajeError();}
                if (comparar("ON")) {
                    if (comparar("Identificador")) {
                        if (comparar("(")) {
                            if (comparar("Identificador")) {
                                if (comparar(")")) {
                                    //que siga
                                }else{return MensajeError();}
                            }else return MensajeError();
                        }else {/*que siga*/}
                    }else if (comparar("PRIMARY")) {
                        //que siga
                    }else{return MensajeError();}
                }
                if (comparar(";")) {
                    return "";
                }else if (comparar("GO")) {
                    return "";
                }else{return MensajeError();}                
            }else{return MensajeError();}
            //mmmmm
//--------------------------------------------------------------------------------------------------------------------------------
        }else if (comparar("VIEW")) {
            if (comparar("Identificador")) {
                if (comparar(".")) {
                    if (comparar("Identificador")) {
                        if (comparar("(")) {
                            if(comparar("Idetificador")) {
                              while(comparar(",")){
                                  if (comparar("Identificador")) {
                                  //que siga
                                  }else{return MensajeError();}
                                }
                                if (comparar(")")) {
                                    if (comparar("AS")) {
                                        if (comparar("SELECT")) {
                                            return SELECTrules();
                                        }else{return MensajeError();}
                                    }else{return MensajeError();}
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else if (comparar("AS")) {
                            if (comparar("SELECT")) {
                                return SELECTrules();
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }else{return MensajeError();}
                }else if (comparar("(")) {
                   if(comparar("Idetificador")) {
                        while(comparar(",")){
                            if (comparar("Identificador")) {
                            //que siga
                            }else{return MensajeError();}
                        }
                        if (comparar(")")) {
                            if (comparar("AS")) {
                                if (comparar("SELECT")) {
                                    return SELECTrules();
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }else{return MensajeError();} 
                }else if (comparar("AS")) {
                    if (comparar("SELECT")) {
                        return SELECTrules();
                    }else{return MensajeError();}
                } else{return MensajeError();}
            }else{return MensajeError();}
//-------------------------------------------            
        }else if (comparar("OR")) {
            if (comparar("ALTER")) {
                if (comparar("VIEW")) {
                    if (comparar("Identificador")) {
                        if (comparar(".")) {
                            if (comparar("Identificador")) {
                                if (comparar("(")) {
                                    if(comparar("Idetificador")) {
                                      while(comparar(",")){
                                          if (comparar("Identificador")) {
                                          //que siga
                                          }else{return MensajeError();}
                                        }
                                        if (comparar(")")) {
                                            if (comparar("AS")) {
                                                if (comparar("SELECT")) {
                                                    return SELECTrules();
                                                }else{return MensajeError();}
                                            }else{return MensajeError();}
                                        }else{return MensajeError();}
                                    }else{return MensajeError();}
                                }else if (comparar("AS")) {
                                    if (comparar("SELECT")) {
                                        return SELECTrules();
                                    }else{return MensajeError();}
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else if (comparar("(")) {
                           if(comparar("Idetificador")) {
                                while(comparar(",")){
                                    if (comparar("Identificador")) {
                                    //que siga
                                    }else{return MensajeError();}
                                }
                                if (comparar(")")) {
                                    if (comparar("AS")) {
                                        if (comparar("SELECT")) {
                                            return SELECTrules();
                                        }else{return MensajeError();}
                                    }else{return MensajeError();}
                                }else{return MensajeError();}
                            }else{return MensajeError();} 
                        }else if (comparar("AS")) {
                            if (comparar("SELECT")) {
                                return SELECTrules();
                            }else{return MensajeError();}
                        } else{return MensajeError();}
                    }else{return MensajeError();}  
                }else{return MensajeError();}
            }else{return MensajeError();}
//--------------------------------------------------------------------------------------------------------------------------------
        }else if (comparar("USER")) {
            if (comparar("Identificador")) {
                if (comparar(";")) {
                    return "";
                }else if (comparar("GO")) {
                    return "";
                }else{return MensajeError();}
            }else{return MensajeError();}        
//--------------------------------------------------------------------------------------------------------------------------------
        }else{
            return MensajeError();
        }
    }
 //--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//-------------FALTA TABLE-------------------------------------------------------------------------------------------------------------------   
    private String ALTERrules(){
        if (comparar("DATABASE")) {
            if (comparar("Identificador")) {
                if (comparar("COLLATE")) {
                    if (comparar("Identificador")) {
                        return "";
                    }else{return MensajeError();}
                }else{
                    while(comparar("SET")){
                        if (comparar("CURSOR")) {
                            if (comparar("CLOSE")) {
                                if (comparar("ON")) {
                                    if (comparar("COMMIT")) {
                                        if (comparar("ON")) {
                                            if (comparar(";")) {
                                                return "";
                                            }else if (comparar("GO")) {
                                                return "";
                                            }else if (comparar(",")) {
                                                //que siga
                                            }else{return MensajeError();}
                                        }else if (comparar("OFF")) {
                                            if (comparar(";")) {
                                                return "";
                                            }else if (comparar("GO")) {
                                                return "";
                                            }else if (comparar(",")) {
                                                //que siga
                                            }else{return MensajeError();}
                                        }else{return MensajeError();}
                                    }else{return MensajeError();}
                                }else{return MensajeError();}
                            }else if (comparar("DEFAULT")) {
                                if (comparar("LOCAL")) {
                                    if (comparar(";")) {
                                        return "";
                                    }else if (comparar("GO")) {
                                        return "";
                                    }else if (comparar(",")) {
                                        //que siga
                                    }else{return MensajeError();}
                                }else if (comparar("GLOBAL")) {
                                    if (comparar(";")) {
                                        return "";
                                    }else if (comparar("GO")) {
                                        return "";
                                    }else if (comparar(",")) {
                                        //que siga
                                    }else{return MensajeError();}
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else if (comparar("READ")) {
                            if (comparar("ONLY")) {
                                if (comparar(";")) {
                                    return "";
                                }else if (comparar("GO")) {
                                    return "";
                                }else if (comparar(",")) {
                                    //que siga
                                }else{return MensajeError();}
                            }else if (comparar("WRITE")) {
                                if (comparar(";")) {
                                    return "";
                                }else if (comparar("GO")) {
                                    return "";
                                }else if (comparar(",")) {
                                    //que siga
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }
                    return MensajeError();
                }
            }else if (comparar("CURRENT")) {
                if (comparar("COLLATE")) {
                    if (comparar("Identificador")) {
                        return "";
                    }else{return MensajeError();}
                }else{
                    while(comparar("SET")){
                        if (comparar("CURSOR")) {
                            if (comparar("CLOSE")) {
                                if (comparar("ON")) {
                                    if (comparar("COMMIT")) {
                                        if (comparar("ON")) {
                                            if (comparar(";")) {
                                                return "";
                                            }else if (comparar("GO")) {
                                                return "";
                                            }else if (comparar(",")) {
                                                //que siga
                                            }else{return MensajeError();}
                                        }else if (comparar("OFF")) {
                                            if (comparar(";")) {
                                                return "";
                                            }else if (comparar("GO")) {
                                                return "";
                                            }else if (comparar(",")) {
                                                //que siga
                                            }else{return MensajeError();}
                                        }else{return MensajeError();}
                                    }else{return MensajeError();}
                                }else{return MensajeError();}
                            }else if (comparar("DEFAULT")) {
                                if (comparar("LOCAL")) {
                                    if (comparar(";")) {
                                        return "";
                                    }else if (comparar("GO")) {
                                        return "";
                                    }else if (comparar(",")) {
                                        //que siga
                                    }else{return MensajeError();}
                                }else if (comparar("GLOBAL")) {
                                    if (comparar(";")) {
                                        return "";
                                    }else if (comparar("GO")) {
                                        return "";
                                    }else if (comparar(",")) {
                                        //que siga
                                    }else{return MensajeError();}
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else if (comparar("READ")) {
                            if (comparar("ONLY")) {
                                if (comparar(";")) {
                                    return "";
                                }else if (comparar("GO")) {
                                    return "";
                                }else if (comparar(",")) {
                                    //que siga
                                }else{return MensajeError();}
                            }else if (comparar("WRITE")) {
                                if (comparar(";")) {
                                    return "";
                                }else if (comparar("GO")) {
                                    return "";
                                }else if (comparar(",")) {
                                    //que siga
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        } else{return MensajeError();}
                    }
                    return MensajeError();
                }
            }else{return MensajeError();}
//--------------------------------------------------------------------------------------------------------------------------------
        }else if (comparar("TABLE")) {
            return "";
//--------------------------------------------------------------------------------------------------------------------------------
        }else if (comparar("VIEW")) {
            if (comparar("Identificador")) {
                if (comparar(".")) {
                    if (comparar("Identificador")) {
                        if (comparar("(")) {
                            if(comparar("Idetificador")) {
                              while(comparar(",")){
                                  if (comparar("Identificador")) {
                                  //que siga
                                  }else{return MensajeError();}
                                }
                                if (comparar(")")) {
                                    if (comparar("AS")) {
                                        if (comparar("SELECT")) {
                                            return SELECTrules();
                                        }else{return MensajeError();}
                                    }else{return MensajeError();}
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else if (comparar("AS")) {
                            if (comparar("SELECT")) {
                                return SELECTrules();
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }else{return MensajeError();}
                }else if (comparar("(")) {
                   if(comparar("Idetificador")) {
                        while(comparar(",")){
                            if (comparar("Identificador")) {
                            //que siga
                            }else{return MensajeError();}
                        }
                        if (comparar(")")) {
                            if (comparar("AS")) {
                                if (comparar("SELECT")) {
                                    return SELECTrules();
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }else{return MensajeError();} 
                }else if (comparar("AS")) {
                    if (comparar("SELECT")) {
                        return SELECTrules();
                    }else{return MensajeError();}
                } else{return MensajeError();}
            }else{return MensajeError();}
//--------------------------------------------------------------------------------------------------------------------------------
        }else if (comparar("USER")) {
            if (comparar("Identificador")) {
                if (comparar(";")) {
                    return "";
                }else if (comparar("GO")) {
                    return "";
                }else{return MensajeError();}
            }else{return MensajeError();}
//--------------------------------------------------------------------------------------------------------------------------------
        }else if (comparar("INDEX")) {
            if (comparar("Identificador")) {
                if (comparar("ON")) {
                    if (comparar("Identificador")) {
                        if (comparar(".")) {
                            if (comparar("Identificador")) {
                                if (comparar(".")) {
                                    if (comparar("Identificiador")) {
                                        if (comparar(";")) {
                                            return "";
                                        }else if (comparar("GO")) {
                                            return "";
                                        }else{return MensajeError();}
                                    } else {return MensajeError();}
                                }else if (comparar(";")) {
                                    return "";
                                }else if (comparar("GO")) {
                                    return "";
                                }else{ return MensajeError(); }
                            }else{return MensajeError();}
                        }else if (comparar(";")) {
                            return "";
                        }else if (comparar("GO")) {
                            return "";
                        }else{ return MensajeError();}
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else if (comparar("ALL")) {
                if (comparar("ON")) {
                    if (comparar("Identificador")) {
                        if (comparar(".")) {
                            if (comparar("Identificador")) {
                                if (comparar(".")) {
                                    if (comparar("Identificiador")) {
                                        if (comparar(";")) {
                                            return "";
                                        }else if (comparar("GO")) {
                                            return "";
                                        }else{return MensajeError();}
                                    } else {return MensajeError();}
                                }else if (comparar(";")) {
                                    return "";
                                }else if (comparar("GO")) {
                                    return "";
                                }else{ return MensajeError(); }
                            }else{return MensajeError();}
                        }else if (comparar(";")) {
                            return "";
                        }else if (comparar("GO")) {
                            return "";
                        }else{ return MensajeError();}
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else{return MensajeError();}
//--------------------------------------------------------------------------------------------------------------------------------
        }else{return MensajeError();}
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
                       }else{return MensajeError();}
                   }
                   return MensajeError();
               }
               if (comparar(";")) {
                   return "";    
               }
               else if (comparar("GO")){
                   return "";
               }
               else{return MensajeError();}
            }else if(comparar("IF")){
               if (comparar("EXISTS")){
                while(comparar("Identificador")){
                    if (comparar(";")){
                        return "";
                    }else if (comparar("GO")){
                        return "";
                    }else if (comparar(",")){
                        //no hago nada porque es correcto
                    }else{return MensajeError();}
                }
                return MensajeError();
             }else{return MensajeError();}
            }else{return MensajeError();}
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
                                         }else{return MensajeError();}
                                     }else{return MensajeError();}
                                }else if (comparar(",")) {
                               //déjelo correr 
                                }else if (comparar(";")) {
                                   return "";
                                }else if (comparar("GO")) {
                                   return "";
                                }else{return MensajeError();}
                            }   
                        }
                        else if (comparar(",")) {
                           //déjelo correr 
                        }else if (comparar(";")) {
                            return "";
                        }else if (comparar("GO")) {
                            return "";
                        }else{return MensajeError();}
                    }
                    return MensajeError();
                }else{return MensajeError();}
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
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else if (comparar(",")) {
                       //déjelo correr 
                        }else if (comparar(";")) {
                           return "";
                        }else if (comparar("GO")) {
                           return "";
                        }else{return MensajeError();}
                    }else{return MensajeError();}              
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
                                 }else{return MensajeError();}
                             }else{return MensajeError();}
                        }else if (comparar(",")) {
                       //déjelo correr 
                        }else if (comparar(";")) {
                           return "";
                        }else if (comparar("GO")) {
                           return "";
                        }else{return MensajeError();}                    
                    }
                    return MensajeError();
                }else{return MensajeError();}
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
                             }else{return MensajeError();}
                         }else{return MensajeError();}
                    }else if (comparar(",")) {
                   //déjelo correr 
                    }else if (comparar(";")) {
                       return "";
                    }else if (comparar("GO")) {
                       return "";
                    }else{return MensajeError();}
                }
                return MensajeError();
            }
//--------------------------------------------------------------------------------------------------------------------------------            
          //DROP 
        }else if (comparar("USER")) {
            if (comparar("Identificador")) {
                if (comparar(";")) {
                    return "";
                }else if (comparar("GO")) {
                    return "";
                }else{return MensajeError();}                
            }else if (comparar("IF")) {
                if (comparar("EXISTS")) {
                    if (comparar("Identificador")) {
                        if (comparar(";")) {
                            return "";
                        }else if (comparar("GO")) {
                            return "";
                        }else{return MensajeError();} 
                    }else{return MensajeError();}
                } else{return MensajeError();}
            }else{return MensajeError();}
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
                                        }else{return MensajeError();}
                                    }else{return MensajeError();}
                                }else if (comparar(";")) {
                                    return "";
                                }else if (comparar("GO")) {
                                    return "";
                                }else if (comparar(",")) {
                                    SeRepitePUNTO = true;
                                }else{return MensajeError();}
                            }else{MensajeError();}
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
                                                }else{return MensajeError();}
                                            } else{return MensajeError();}
                                        } else if (comparar(";")) {
                                            return "";
                                        }else if (comparar("GO")) {
                                            return "";
                                        }else if (comparar(",")){
                                            SeRepiteON = true;
                                        }else{return MensajeError();}
                                    }else{return MensajeError();}
                                }else if (comparar(";")) {
                                    return "";
                                }else if (comparar("GO")) {
                                    return "";
                                }else if (comparar(",")){
                                    SeRepiteON =true;
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }else{return MensajeError();}
                }else{return MensajeError();}
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
                                    }else{return MensajeError();}
                                }else{return MensajeError();}
                            }else if (comparar(";")) {
                                return "";
                            }else if (comparar("GO")) {
                                return "";
                            }else if (comparar(",")) {
                                SeRepitePUNTO = true;
                            }else{return MensajeError();}
                        }else{MensajeError();}
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
                                            }else{return MensajeError();}
                                        } else{return MensajeError();}
                                    } else if (comparar(";")) {
                                        return "";
                                    }else if (comparar("GO")) {
                                        return "";
                                    }else if (comparar(",")){
                                        SeRepiteON = true;
                                    }else{return MensajeError();}
                                }else{return MensajeError(); }
                            }else if (comparar(";")) {
                                return "";
                            }else if (comparar("GO")) {
                                return "";
                            }else if (comparar(",")){
                                SeRepiteON =true;
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }else{return MensajeError();}
                }else{return MensajeError();}
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
                                    }else{return MensajeError();}
                                }else{return MensajeError();}
                            }else if (comparar(";")) {
                                return "";
                            }else if (comparar("GO")) {
                                return "";
                            }else if (comparar(",")) {
                                //que siga
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }else{return MensajeError();}
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
                                            }else{return MensajeError();}
                                        } else{return MensajeError();}
                                    } else if (comparar(";")) {
                                        return "";
                                    }else if (comparar("GO")) {
                                        return "";
                                    }else if (comparar(",")){
                                        //que siga
                                    }else{return MensajeError();}
                                }else{return MensajeError(); }
                            }else if (comparar(";")) {
                                return "";
                            }else if (comparar("GO")) {
                                return "";
                            }else if (comparar(",")){
                                //que siga
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }else{return MensajeError();}
                }
                return MensajeError();
            }else{return MensajeError();}
//--------------------------------------------------------------------------------------------------------------------------------
        }else{return MensajeError();}
    }
    
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------
//--------------------TERMINADO---------------------------------------------------------------------------------------------------  
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
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else if (comparar(";")) {
                            return "";
                        }else if (comparar("GO")) {
                            return "";
                        }else{return MensajeError();}
                    } else{return MensajeError();}
                }else if (comparar(";")) {
                    return "";
                }else if (comparar("GO")) {
                    return "";
                }else{return MensajeError();}
            }else{return MensajeError();}
        }else{return MensajeError();}
    }    
//------------------------------------------------------------------------------------------------------------    
    private boolean comparar(String esperado){
        if (lookahead<=a.length-1) {
            if (esperado.equals(a[lookahead].split("\\|")[0])) {
                lookahead++;
                return true;
            }
            else{return false;}
        }else {return false;}
    }
    private String MensajeError(){
        if (lookahead>a.length-1) {
            return "ERROR: Statement incompleto";
        }
        else{
            return "ERROR: no se esperaba un <" + a[lookahead].split("\\|")[0]
                        + "> en la linea: " + a[lookahead].split("\\|")[1];
        }
    }
    
    
    private boolean WHERErules(){
        return true;
    }
    private String GenericINDEXrulesForCREATE(){
        if (comparar("Identificador")) {
                if (comparar("ON")) {
                    if (comparar("Identificador")) {
                        if (comparar(".")) {
                            if (comparar("Identificador")) {
                                if (comparar(".")) {
                                    if (comparar("Identificador")) {
                                        if (comparar("(")) {
                                            while(comparar("Identificador")){
                                                if (comparar(",")) {
                                                    //que siga el while
                                                }else if (comparar("ASC")) {
                                                    if (comparar(",")) {
                                                        //que siga
                                                    }else{break;}
                                                }else if(comparar("DESC")){
                                                    if (comparar(",")) {
                                                        //que siga
                                                    }else{break;}
                                                }else{break;}
                                            }
                                            if(comparar(")")){
                                                if(comparar("INCLUDE")){
                                                    if (comparar("(")) {
                                                        while(comparar("Identificador")){
                                                            if (comparar(",")) {
                                                                //que siga el while                                                            
                                                            }else{break;}
                                                        }
                                                        if (comparar(")")) {
                                                           //correcto, pero que siga preguntando si hay statements 
                                                        }else{return MensajeError();}
                                                    }else{return MensajeError();}
                                                }
                                                if(comparar("WHERE")){
                                                    if (WHERErules()) {
                                                       //correcto, pero que siga preguntando si hay statements 
                                                    }else{return MensajeError();}
                                                }
                                                if(comparar("ON")){
                                                    if (comparar("Identificador")) {
                                                        if (comparar("(")) {
                                                            if (comparar("Identificador")) {
                                                                if (comparar(")")) {
                                                                    //correcto, pero que pase a preguntar si hay fin de statement
                                                                }else{return MensajeError();}
                                                            }else{return MensajeError();}
                                                        }
                                                    }else{return MensajeError();}
                                                }
                                                if (comparar(";")) {
                                                    return"";
                                                }else if (comparar("GO")) {
                                                    return "";
                                                }else{return MensajeError();}
                                            }else{return MensajeError();}
                                        }else {return MensajeError();}
                                    }else{return MensajeError();}
                                }else if (comparar("(")) {
                                    while(comparar("Identificador")){
                                        if (comparar(",")) {
                                            //que siga el while
                                        }else if (comparar("ASC")) {
                                            if (comparar(",")) {
                                                //que siga
                                            }else{break;}
                                        }else if(comparar("DESC")){
                                            if (comparar(",")) {
                                                //que siga
                                            }else{break;}
                                        }else{break;}
                                    }
                                    if(comparar(")")){
                                        if(comparar("INCLUDE")){
                                            if (comparar("(")) {
                                                while(comparar("Identificador")){
                                                    if (comparar(",")) {
                                                        //que siga el while                                                            
                                                    }else{break;}
                                                }
                                                if (comparar(")")) {
                                                   //correcto, pero que siga preguntando si hay statements 
                                                }else{return MensajeError();}
                                            }else{return MensajeError();}
                                        }
                                        if(comparar("WHERE")){
                                            if (WHERErules()) {
                                               //correcto, pero que siga preguntando si hay statements 
                                            }else{return MensajeError();}
                                        }
                                        if(comparar("ON")){
                                            if (comparar("Identificador")) {
                                                if (comparar("(")) {
                                                    if (comparar("Identificador")) {
                                                        if (comparar(")")) {
                                                            //correcto, pero que pase a preguntar si hay fin de statement
                                                        }else{return MensajeError();}
                                                    }else{return MensajeError();}
                                                }
                                            }else{return MensajeError();}
                                        }
                                        if (comparar(";")) {
                                            return"";
                                        }else if (comparar("GO")) {
                                            return "";
                                        }else{return MensajeError();}
                                    }else{return MensajeError();}
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else if (comparar("(")) {
                            while(comparar("Identificador")){
                                if (comparar(",")) {
                                    //que siga el while
                                }else if (comparar("ASC")) {
                                    if (comparar(",")) {
                                        //que siga
                                    }else{break;}
                                }else if(comparar("DESC")){
                                    if (comparar(",")) {
                                        //que siga
                                    }else{break;}
                                }else{break;}
                            }
                            if(comparar(")")){
                                if(comparar("INCLUDE")){
                                    if (comparar("(")) {
                                        while(comparar("Identificador")){
                                            if (comparar(",")) {
                                                //que siga el while                                                            
                                            }else{break;}
                                        }
                                        if (comparar(")")) {
                                           //correcto, pero que siga preguntando si hay statements 
                                        }else{return MensajeError();}
                                    }else{return MensajeError();}
                                }
                                if(comparar("WHERE")){
                                    if (WHERErules()) {
                                       //correcto, pero que siga preguntando si hay statements 
                                    }else{return MensajeError();}
                                }
                                if(comparar("ON")){
                                    if (comparar("Identificador")) {
                                        if (comparar("(")) {
                                            if (comparar("Identificador")) {
                                                if (comparar(")")) {
                                                    //correcto, pero que pase a preguntar si hay fin de statement
                                                }else{return MensajeError();}
                                            }else{return MensajeError();}
                                        }
                                    }else{return MensajeError();}
                                }
                                if (comparar(";")) {
                                    return"";
                                }else if (comparar("GO")) {
                                    return "";
                                }else{return MensajeError();}
                            }else{return MensajeError();}
                        }else{return MensajeError();}
                    }else{return MensajeError();}
                }else{return MensajeError();}
            }else{return MensajeError();}
    }
}
