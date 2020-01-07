public class Genome {
    private String sequence;

    public Genome(String current_dna) {
        this.sequence = current_dna;
    }

    public void addNucleotide(char c) {
        this.sequence += c;
    }

    public char nucleotideAt(int i) {
        return this.sequence.charAt(i);
    }

    public boolean isPotentialGene() {
        if (this.sequence.length() % 3 != 0) return false;
        if (!this.sequence.startsWith("ATG")) return false;
        for (int i = 3; i < this.sequence.length() - 3; i++) {
            if (i % 3 == 0) {
                String codon = this.sequence.substring(i, i + 3);
                if (codon.equals("TAA")) return false;
                if (codon.equals("TAG")) return false;
                if (codon.equals("TGA")) return false;
            }
        }

        if (this.sequence.endsWith("TAA")) return true;
        if (this.sequence.endsWith("TAG")) return true;
        if (this.sequence.endsWith("TGA")) return true;

        return false;
    }

    public String complementWatsonCrick() {
        String ans = "";
        for (int i = 0; i < this.sequence.length(); i++) {
            if (this.sequence.charAt(i) == 'A') ans += 'T';
            if (this.sequence.charAt(i) == 'T') ans += 'A';
            if (this.sequence.charAt(i) == 'C') ans += 'G';
            if (this.sequence.charAt(i) == 'G') ans += 'C';
        }
        return ans;
    }
}