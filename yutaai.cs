using System;
using System.Net.Http;
using System.Threading.Tasks;

class YutaAIApp {
  static async Task Main(){
    var client=new HttpClient();
    Console.Write("質問: "); 
    string q=Console.ReadLine();
    var res=await client.PostAsJsonAsync("http://localhost:5000/ask", new { q });
    var ans=await res.Content.ReadAsStringAsync();
    Console.WriteLine("YutaAI: "+ans);
  }
}
