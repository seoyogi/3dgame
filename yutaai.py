from flask import Flask, request, jsonify
import random

app = Flask(__name__)

@app.route('/ask', methods=['POST'])
def ask():
    data = request.get_json()
    q = data.get('q','')
    # 簡易AI：ランダムに返す（本物のGPTモデルならOpenAI API呼ぶ）
    responses = [
        "それ面白いね！",
        "なるほど、そう考えるんだ。",
        "もう少し詳しく教えてくれる？",
        "それについては勉強中なんだ😅"
    ]
    return jsonify(answer=random.choice(responses))

if __name__=="__main__":
    app.run(debug=True)
