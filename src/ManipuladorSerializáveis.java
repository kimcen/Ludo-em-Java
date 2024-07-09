import java.io.*;


public class ManipuladorSerializáveis {

    public static void serializa(String nomeArquivo, Object objeto) {
        try {
            FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
            ObjectOutputStream arquivoObj = new ObjectOutputStream(arquivo);
            arquivoObj.writeObject(objeto);
            arquivoObj.close();
            arquivo.close();
        } catch (IOException e1) {
            System.out.println("O ARQUIVO QUE TENTOU ABRIR, NÃO PODE SER ABERTO");
        }
    }

    public static Object desserializa(String nomeArquivo) {
        Object objeto = null;
        try {
            FileInputStream arquivo = new FileInputStream(nomeArquivo);
            ObjectInputStream arquivoObj = new ObjectInputStream(arquivo);
            objeto = (Object) arquivoObj.readObject();
            arquivoObj.close();
            arquivo.close();
        } catch (IOException e1) {
            System.out.println("O ARQUIVO QUE TENTOU ABRIR, NÃO PODE SER ABERTO");
        } catch (ClassNotFoundException e2) {
            System.out.println("CLASSE NÃO ENCONTRADA");
        }
        return objeto;
    }
}
