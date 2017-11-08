class ReverseWords {
    public String reverseWords(String s) {
        String sol = "";

        while (s.length() != 0) {
            int i = 0;
            while(s.charAt(i) != ' ') {

            }
        }

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                System.out.println(s);
                System.out.println(sol);
                sol += s.substring(0,i+1);
                System.out.println(s);
                System.out.println(sol);
                s = s.replace(s.substring(0,i+1),"");
                System.out.println(s);
                System.out.println(sol);
            }
        }
        return sol;
    }
}