class Encrypter {
    String key_value[]=new String[26];
    HashMap<String, Integer> encrypted_dictionary=new HashMap<>();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        int i=0;
        for(char key: keys) key_value[key-'a']=values[i++];
        
        for(String word: dictionary) {
            String encr=encrypt(word);
            if(encr==null) continue;
            encrypted_dictionary.put(encr, encrypted_dictionary.getOrDefault(encr, 0) + 1);
        }
    }
    
    public String encrypt(String word1) {
        char[] res=new char[word1.length()*2];
        for(int i=0;i<word1.length();i++) {
            try{
                res[i*2]=key_value[word1.charAt(i)-'a'].charAt(0);
                res[i*2+1]=key_value[word1.charAt(i)-'a'].charAt(1);
            }catch(Exception e){
                return null;
            }
        }
        return new String(res);
    }
    
    public int decrypt(String word2) {
        return encrypted_dictionary.getOrDefault(word2, 0);
    }
}