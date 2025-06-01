import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorMoneda extends JFrame {
    private JComboBox<String> cmbOrigen, cmbDestino;
    private JTextField txtCantidad;
    private JLabel lblResultado;
    private List<String> historial = new ArrayList<>();

    private final String[] monedas = {"USD", "ARS", "EUR", "BRL", "CLP", "COP", "MXN"};

    public ConversorMoneda() {
        setTitle("Conversor de Moneda");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Componentes
        add(new JLabel("Moneda Origen:"));
        cmbOrigen = new JComboBox<>(monedas);
        add(cmbOrigen);

        add(new JLabel("Moneda Destino:"));
        cmbDestino = new JComboBox<>(monedas);
        add(cmbDestino);

        add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        add(txtCantidad);

        JButton btnConvertir = new JButton("Convertir");
        add(btnConvertir);

        lblResultado = new JLabel("Resultado: ");
        add(lblResultado);

        JButton btnHistorial = new JButton("Ver Historial");
        add(btnHistorial);

        // Acción del botón Convertir
        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String origen = cmbOrigen.getSelectedItem().toString();
                String destino = cmbDestino.getSelectedItem().toString();

                if (origen.equals(destino)) {
                    lblResultado.setText("Monedas no pueden ser iguales.");
                    return;
                }

                double cantidad;
                try {
                    cantidad = Double.parseDouble(txtCantidad.getText());
                } catch (NumberFormatException ex) {
                    lblResultado.setText("Cantidad inválida");
                    return;
                }

                double resultado = convertirMoneda(origen, destino, cantidad);
                if (resultado != -1) {
                    String conversion = String.format("%.2f %s = %.2f %s", cantidad, origen, resultado, destino);
                    lblResultado.setText("Resultado: " + conversion);
                    historial.add(conversion);
                } else {
                    lblResultado.setText("Error al obtener los datos.");
                }
            }
        });

        // Acción del botón Historial
        btnHistorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (historial.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay conversiones aún.");
                } else {
                    StringBuilder sb = new StringBuilder("Historial de conversiones:\n");
                    for (String entry : historial) {
                        sb.append(entry).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
            }
        });
    }

    private double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        try {
            String API_URL = "https://api.exchangerate-api.com/v4/latest/" + monedaOrigen;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("rates");
            double tasaCambio = rates.get(monedaDestino).getAsDouble();

            return cantidad * tasaCambio;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConversorMoneda().setVisible(true));
    }
}
