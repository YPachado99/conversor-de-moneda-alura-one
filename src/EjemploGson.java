import com.google.gson.Gson;

public class EjemploGson {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", 30);

        Gson gson = new Gson();

        String json = gson.toJson(persona);
        System.out.println("JSON: " + json);

        Persona personaDeserializada = gson.fromJson(json, Persona.class);
        System.out.println("Nombre deserializado: " + personaDeserializada.getNombre());
    }
}
