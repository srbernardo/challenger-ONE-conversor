import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

class Cotacao {
	private static double cotacao;

	public static double getCotacao(String nome) {
		String urlApi = "https://economia.awesomeapi.com.br/json/" + nome;
		try {
			URL url = new URL(urlApi);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			String json = response.toString().replaceAll("[\\[\\]]", "");
			Gson gson = new Gson();
			Moeda moeda = gson.fromJson(json, Moeda.class);
			cotacao = moeda.getAsk();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cotacao;
	}
}
