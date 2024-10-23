import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket conexao =  new Socket("127.0.0.1", 2001);

        try(DataInputStream entrada = new DataInputStream(conexao.getInputStream());
            DataOutputStream saida = new DataOutputStream(conexao.getOutputStream());
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))
        ) {

            while (true) {
                System.out.println("> ");
                String linha = teclado.readLine();
                saida.writeUTF(linha);


                linha = entrada.readUTF();
                if(linha.isEmpty()) {
                    System.out.println("Conexao errada!");
                    break;
                }
                System.out.println(linha);
            }
        }
    }
}