import okhttp3.*
import org.json.JSONObject

fun askAI(question:String){
    val client = OkHttpClient()
    val json = JSONObject()
    json.put("q", question)
    val body = RequestBody.create(MediaType.get("application/json"), json.toString())
    val request = Request.Builder().url("http://10.0.2.2:5000/ask").post(body).build()
    client.newCall(request).execute().use { response ->
        println("YutaAI: "+response.body!!.string())
    }
}
