package Interviews.Problem;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class IpChecker {

    boolean checkIpAddress(String ip, List<String> rules) {
        InetAddress addressToCheck = null;
        try {
            addressToCheck = InetAddress.getByName(ip);

            

        } catch (UnknownHostException e) {
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
    }

}
