import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        Encryptor enc = new Encryptor();

        String[] options = {"Criptografar", "Descriptografar", "Sair"};

        while(true) {

            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "O que deseja fazer?",
                    "Criptografia com Java",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if ( escolha == 0) {
                enc.encryptString();
            } else if (escolha == 1){
                enc.decryptString();
            } else {
                System.exit(0);
            }

        }

    }

}
