# 💱 Conversor de Monedas - Java + API ExchangeRate

## 📌 Descripción

Este proyecto es un conversor de monedas desarrollado en Java con interfaz gráfica utilizando **Swing**. Se conecta a la API pública de [ExchangeRate-API](https://www.exchangerate-api.com) para obtener los valores de conversión entre distintas divisas en tiempo real.

Forma parte del desafío final del programa **ONE (Oracle Next Education)**.

---

## 🧠 Funcionalidades

- ✔️ Conversión en tiempo real entre diferentes monedas.
- ✔️ Interfaz amigable y funcional con `JFrame`.
- ✔️ Uso de `HttpClient` para peticiones HTTP.
- ✔️ Integración con la API pública de tipo de cambio.
- ✔️ Validación de entrada del usuario.
- ✔️ Prevención de selección de la misma moneda.
- ✔️ Historial de conversiones con fecha y hora.
- ✔️ Manejo de errores (API, entradas inválidas, códigos inexistentes).
- ✔️ Selección de monedas desde menú desplegable (`JComboBox`).

---

## 🌎 Monedas soportadas

Las monedas filtradas y permitidas en esta versión son:

- 🇦🇷 ARS - Peso argentino  
- 🇧🇴 BOB - Boliviano  
- 🇧🇷 BRL - Real brasileño  
- 🇨🇱 CLP - Peso chileno  
- 🇨🇴 COP - Peso colombiano  
- 🇺🇸 USD - Dólar estadounidense  
- 🇪🇺 EUR - Euro  

---

## 🧪 Ejemplo de uso

1. Seleccioná la **moneda de origen** desde el menú desplegable.
2. Seleccioná la **moneda destino** desde el otro menú.
3. Ingresá la **cantidad a convertir**.
4. Presioná el botón **"Convertir"**.
5. El resultado se mostrará en pantalla con una descripción clara.
6. También podés consultar el **historial** de conversiones.

---

## 📦 Tecnologías utilizadas

- 🧩 Java 17+
- 🖼️ Swing (Interfaz gráfica)
- 🔗 Java HTTP Client (`java.net.http`)
- 📦 Gson (Lectura y parseo de JSON)
- 🌐 ExchangeRate API (para tasas de cambio)

---

## 🚀 Instalación y ejecución

1. Cloná el repositorio o descargá los archivos fuente.
2. Abrí el proyecto en tu IDE favorito (Eclipse, IntelliJ, VS Code, etc.).
3. Asegurate de tener Java 17+ configurado.
4. Añadí la librería [Gson](https://github.com/google/gson) al classpath.
5. Ejecutá el archivo `ConversorMoneda.java`.

```bash
javac ConversorMoneda.java
java ConversorMoneda

