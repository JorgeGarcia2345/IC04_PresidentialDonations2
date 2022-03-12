import java.text.NumberFormat;

public class Canidate
{
    private double totalContribution;
    private double largestDonation = Double.MIN_VALUE;
    private double lowestDonation = Double.MAX_VALUE;
    private String name;
    private int numContribution;

    public Canidate(double totalContribution, double largestDonation, double lowestDonation, String name, int numContribution) {
        this.totalContribution = totalContribution;
        this.largestDonation = largestDonation;
        this.lowestDonation = lowestDonation;
        this.name = name;
        this.numContribution = numContribution;
    }

    public Canidate(String name)
    {
        this.name = name;
    }

    public double getTotalContribution() {
        return totalContribution;
    }

    public void setTotalContribution(double totalContribution) {
        this.totalContribution = totalContribution;
    }

    public double getLargestDonation() {
        return largestDonation;
    }

    public void setLargestDonation(double largestDonation) {
        this.largestDonation = largestDonation;
    }

    public double getLowestDonation() {
        return lowestDonation;
    }

    public void setLowestDonation(double lowestDonation) {
        this.lowestDonation = lowestDonation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumContribution() {
        return numContribution;
    }

    public void setNumContribution(int numContribution) {
        this.numContribution = numContribution;
    }


    public void updateContributionInfo(double donation)
    {
        if (donation > 0)
        {
            this.updateTotalContributions(donation);
            this.updateLargestDonation(donation);
            this.updateLowestDonation(donation);
        }
    }

    public void updateTotalContributions(Double contribution)
    {
        this.totalContribution += contribution;
        this.numContribution++;
    }

    public void updateLargestDonation(double donation)
    {
        if (donation > this.largestDonation)
        {
            this.largestDonation = donation;
        }
    }

    public void updateLowestDonation(double donation)
    {
        if (donation < this.lowestDonation)
        {
            this.lowestDonation = donation;
        }
    }


    public String toString ()
    {
        double averageContribution = this.totalContribution / this.numContribution;

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String runningString =
        "****************************************\n" +
        "* 2020 Presidential Campaign Donations *\n" +
        "*           for Canidate:              *\n" +
        String.format("*%11s%-27s*%n","",this.name) +
        "*****************************************\n" +
        "The Minimum Contribution was: " + currency.format(this.lowestDonation) +
        "\nThe Maximum Contribution was: " + currency.format(this.largestDonation) +
        "\nThe Average Contribution was: " + currency.format(averageContribution) +
        "\nThe Number of Contribution were: " + this.numContribution +
        "\nThe total amount contributed was: " + currency.format(this.totalContribution);

        return runningString;
    }





}
