import javax.swing.JOptionPane;

public class Encryptor {


    public void encryptString () {
        int key = getEncryptKey();
        String content = getEncryptContent();

        char[] array = content.toCharArray();

        int[] asciiValues = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            asciiValues[i] = (int) array[i] + key;
            array[i] = (char) asciiValues[i];
        }

        content = new String(array);

        JOptionPane.showMessageDialog(
                null,
                content,
                "Criptografado com sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void decryptString () {
        int key = getEncryptKey();
        String content = getEncryptContent();

        char[] array = content.toCharArray();

        int[] asciiValues = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            asciiValues[i] = (int) array[i] - key;
            array[i] = (char) asciiValues[i];
        }

        content = new String(array);

        JOptionPane.showMessageDialog(
                null,
                content,
                "Descriptografado com sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

    public int getEncryptKey () {

        int key = 0;

        do{
            String input = JOptionPane.showInputDialog("Escolha uma chave de criptografia inteira");
            try {
                key = Integer.parseInt(input);

                if(key == 0){
                    JOptionPane.showMessageDialog(
                            null,
                            "Você escolheu a chave 0! Por consequência, a saída será exatamente igual a entrada.",
                            "Atenção!",
                            JOptionPane.WARNING_MESSAGE
                    );
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Certifique-se de escolher um número inteiro",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        } while ( key == 0);

        return key;

    }

    public String getEncryptContent () {

        String content = "";
        do{
            try{
                content = JOptionPane.showInputDialog("Digite o conteúdo a ser criptografado");
                if(content.isEmpty()) {
                    throw new Exception("Não é possível criptografar uma string vazia.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        e,
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }

        } while (content.isEmpty());

        return content;
    }

}
