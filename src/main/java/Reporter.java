public class Reporter {
    public String report(Parkable parkable, int num, StringBuilder reportStr) {
        String postSeparator = "\n";
        String preSeparator = "--";
        for(int i = 0;i<num;i++){
            reportStr.append(preSeparator);
        }
        reportStr.append(parkable.getName() + postSeparator);
        for(Parkable child : parkable.getParkableList()){
            num += 1;
            report(child,num,reportStr);
            num -= 1;
        }
        return reportStr.toString();
    }
}
