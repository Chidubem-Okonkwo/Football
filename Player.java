import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Player {
    String firstName = "";
    String lastName = "";

    enum Handedness {
        R, L
    };

    Handedness h = Handedness.R;

    enum PlayerPosition {
        QB, RB, FB, WR, TE, OL, DE, DT, LB, CB, S, K, P, LS
    };

    PlayerPosition position = PlayerPosition.QB;
    String homeTown = "Abbeville";
    String homeState = "Alabama";
    String homeCountry = "United States of America";

    public static String RandomName(String f) throws FileNotFoundException {
        File file = new File(f);
        Scanner sc = new Scanner(file);
        Scanner sc1 = new Scanner(file);
        ArrayList<Integer> timesUsed = new ArrayList<Integer>();
        ArrayList<String> names = new ArrayList<String>();
        int totalPeople = 0;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            timesUsed.add(Integer.parseInt(str.substring(str.indexOf(":") + 1, str.length())));
        }
        while (sc1.hasNextLine()) {
            String str = sc1.nextLine();
            names.add(str.substring(0, str.indexOf(":")));
        }

        for (int i = 0; i < timesUsed.size(); i++) {
            totalPeople += timesUsed.get(i);
        }

        Random randomNum = new Random();
        int result = randomNum.nextInt(totalPeople - 1) + 1;
        int currentSum = 0;
        String name = "";
        for (int i = 0; i < timesUsed.size(); i++) {
            currentSum += timesUsed.get(i);
            if (currentSum - result >= 0 && currentSum - result < timesUsed.get(i)) {
                name = names.get(i);
                break;
            }

        }
        sc.close();
        sc1.close();
        return name;
    }

    private void RandomPerson() throws FileNotFoundException {
        int height; 
        
        Random randomNum = new Random();
        int randPosition = randomNum.nextInt(2201) + 1;
        int randHyphenated = randomNum.nextInt(10000) + 1;
        int randSuffix = randomNum.nextInt(10000) + 1;
        int randWhichSuffix = randomNum.nextInt(100) + 1;
        int randHandedness = randomNum.nextInt(10) + 1;

        if (randHandedness == 1)
            h = Handedness.L;
        else
            h = Handedness.R;
        if (randPosition <= 244) {
            position = PlayerPosition.CB;
            int randRace = randomNum.nextInt(244) + 1;
            if (randRace <= 238) {
                firstName = RandomName("AfricanAmericanFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("AfricanAmericanSurnames.txt") + "-"
                            + RandomName("AfricanAmericanSurnames.txt");
                } else {
                    lastName = RandomName("AfricanAmericanSurnames.txt");
                }
                
            }
            else {
                firstName = RandomName("IgboFirstNames.txt");
                lastName = RandomName("IgboSurnames.txt");
            }
            height = RandomHeight("CBHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("CBWeight.txt"));
            
        } else if (randPosition > 244 && randPosition <= 445) {
            position = PlayerPosition.DE;
            int randRace = randomNum.nextInt(201) + 1;
            if (randRace <= 162) {
                firstName = RandomName("AfricanAmericanFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("AfricanAmericanSurnames.txt") + "-"
                            + RandomName("AfricanAmericanSurnames.txt");
                } else {
                    lastName = RandomName("AfricanAmericanSurnames.txt");
                }
            }
            else if (randRace > 162 && randRace <= 193) {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            else if (randRace == 194) {
                firstName = RandomName("PolynesianFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("PolynesianSurnames.txt") + "-"
                            + RandomName("PolynesianSurnames.txt");
                } else {
                    lastName = RandomName("PolynesianSurnames.txt");
                }
            }
            else if (randRace > 194 && randRace <= 199) {
                firstName = RandomName("IgboFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("IgboSurnames.txt") + "-"
                            + RandomName("IgboSurnames.txt");
                } else {
                    lastName = RandomName("IgboSurnames.txt");
                }
            }
            else {
                firstName = RandomName("HispanicFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("HispanicSurnames.txt") + "-"
                            + RandomName("HispanicSurnames.txt");
                } else {
                    lastName = RandomName("HispanicSurnames.txt");
                }           
            }
            height = RandomHeight("DEHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("DEWeight.txt"));
                
        } else if (randPosition > 445 && randPosition <= 585) {
            position = PlayerPosition.DT;
            int randRace = randomNum.nextInt(140) + 1;
            if (randRace <= 115) {
                firstName = RandomName("AfricanAmericanFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("AfricanAmericanSurnames.txt") + "-"
                            + RandomName("AfricanAmericanSurnames.txt");
                } else {
                    lastName = RandomName("AfricanAmericanSurnames.txt");
                }
            }
            else if (randRace > 115 && randRace <= 124) {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            else if (randRace > 124 && randRace <= 134) {
                firstName = RandomName("PolynesianFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("PolynesianSurnames.txt") + "-"
                            + RandomName("PolynesianSurnames.txt");
                } else {
                    lastName = RandomName("PolynesianSurnames.txt");
                }
            }
            else if (randRace > 134 && randRace <= 137) {
                firstName = RandomName("IgboFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("IgboSurnames.txt") + "-"
                            + RandomName("IgboSurnames.txt");
                } else {
                    lastName = RandomName("IgboSurnames.txt");
                }
            }
            else {
                firstName = RandomName("HispanicFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("HispanicSurnames.txt") + "-"
                            + RandomName("HispanicSurnames.txt");
                } else {
                    lastName = RandomName("HispanicSurnames.txt");
                }
            }
            height = RandomHeight("DTHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("DTWeight.txt"));
        } else if (randPosition > 585 && randPosition <= 618) {
            position = PlayerPosition.FB;
            int randRace = randomNum.nextInt(33) + 1;
            if (randRace <= 11) {
                firstName = RandomName("AfricanAmericanFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("AfricanAmericanSurnames.txt") + "-"
                            + RandomName("AfricanAmericanSurnames.txt");
                } else {
                    lastName = RandomName("AfricanAmericanSurnames.txt");
                }
            }
            else if (randRace > 11 && randRace <= 28) {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            else if (randRace > 28 && randRace <= 31) {
                firstName = RandomName("PolynesianFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("PolynesianSurnames.txt") + "-"
                            + RandomName("PolynesianSurnames.txt");
                } else {
                    lastName = RandomName("PolynesianSurnames.txt");
                }
            }
            else if (randRace == 32) {
                firstName = RandomName("IgboFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("IgboSurnames.txt") + "-"
                            + RandomName("IgboSurnames.txt");
                } else {
                    lastName = RandomName("IgboSurnames.txt");
                }
            }
            else {
                firstName = RandomName("HispanicFirstNames.txt");
                
            }
            height = RandomHeight("FBHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("FBWeight.txt"));
        } else if (randPosition > 618 && randPosition <= 655) {
            position = PlayerPosition.K;
            int randRace = randomNum.nextInt(37) + 1;
            if (randRace <= 35) {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            else {
                firstName = RandomName("HispanicFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("HispanicSurnames.txt") + "-"
                            + RandomName("HispanicSurnames.txt");
                } else {
                    lastName = RandomName("HispanicSurnames.txt");
                }
            }
            height = RandomHeight("KHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("KWeight.txt"));
        } else if (randPosition > 655 && randPosition <= 949) {
            position = PlayerPosition.LB;
            int randRace = randomNum.nextInt(294) + 1;
            if (randRace <= 222) {
                firstName = RandomName("AfricanAmericanFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("AfricanAmericanSurnames.txt") + "-"
                            + RandomName("AfricanAmericanSurnames.txt");
                } else {
                    lastName = RandomName("AfricanAmericanSurnames.txt");
                }
            }
            else if (randRace > 222 && randRace <= 276) {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            else if (randRace > 276 && randRace <= 284) {
                firstName = RandomName("PolynesianFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("PolynesianSurnames.txt") + "-"
                            + RandomName("PolynesianSurnames.txt");
                } else {
                    lastName = RandomName("PolynesianSurnames.txt");
                }
            }
            else if (randRace > 284 && randRace <= 289) {
                firstName = RandomName("IgboFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("IgboSurnames.txt") + "-"
                            + RandomName("IgboSurnames.txt");
                } else {
                    lastName = RandomName("IgboSurnames.txt");
                }
            }
            else {
                firstName = RandomName("HispanicFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("HispanicSurnames.txt") + "-"
                            + RandomName("HispanicSurnames.txt");
                } else {
                    lastName = RandomName("HispanicSurnames.txt");
                }
                
            }
            height = RandomHeight("LBHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("LBWeight.txt"));
        } else if (randPosition > 949 && randPosition <= 986) {
            position = PlayerPosition.LS;
            int randRace = randomNum.nextInt(37) + 1;
            if (randRace <= 36) {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            else {
                firstName = RandomName("HispanicFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("HispanicSurnames.txt") + "-" + RandomName("HispanicSurnames.txt");
                }
                else {
                    lastName = RandomName("HispanicSurnames.txt");
                }
            }
            height = RandomHeight("LSHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("LSWeight.txt"));
        } else if (randPosition > 986 && randPosition <= 1338) {
            position = PlayerPosition.OL;
            int randRace = randomNum.nextInt(352) + 1;
            if (randRace <= 152) {
                firstName = RandomName("AfricanAmericanFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("AfricanAmericanSurnames.txt") + "-"
                            + RandomName("AfricanAmericanSurnames.txt");
                } else {
                    lastName = RandomName("AfricanAmericanSurnames.txt");
                }
            }
            else if (randRace > 152 && randRace <= 332) {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            else if (randRace > 332 && randRace <= 338) {
                firstName = RandomName("PolynesianFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("PolynesianSurnames.txt") + "-"
                            + RandomName("PolynesianSurnames.txt");
                } else {
                    lastName = RandomName("PolynesianSurnames.txt");
                }
            }
            else if (randRace > 338 && randRace <= 345) {
                firstName = RandomName("IgboFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("IgboSurnames.txt") + "-"
                            + RandomName("IgboSurnames.txt");
                } else {
                    lastName = RandomName("IgboSurnames.txt");
                }
            }
            else {
                firstName = RandomName("HispanicFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("HispanicSurnames.txt") + "-"
                            + RandomName("HispanicSurnames.txt");
                } else {
                    lastName = RandomName("HispanicSurnames.txt");
                }
                
            }
            height = RandomHeight("OLHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("OLWeight.txt"));
        } else if (randPosition > 1338 && randPosition <= 1374) {
            position = PlayerPosition.P;
            int randRace = randomNum.nextInt(36) + 1;
            if (randRace == 1) {
                firstName = RandomName("AfricanAmericanFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("AfricanAmericanSurnames.txt") + "-"
                            + RandomName("AfricanAmericanSurnames.txt");
                } else {
                    lastName = RandomName("AfricanAmericanSurnames.txt");
                }
            }
            else {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            height = RandomHeight("PHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("PWeight.txt"));
        } else if (randPosition > 1374 && randPosition <= 1472) {
            position = PlayerPosition.QB;
            int randRace = randomNum.nextInt(98) + 1;
            if (randRace <= 18) {
                firstName = RandomName("AfricanAmericanFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("AfricanAmericanSurnames.txt") + "-"
                            + RandomName("AfricanAmericanSurnames.txt");
                } else {
                    lastName = RandomName("AfricanAmericanSurnames.txt");
                }
            }
            else if (randRace > 18 && randRace <= 95) {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            else if (randRace == 96) {
                firstName = RandomName("PolynesianFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("PolynesianSurnames.txt") + "-"
                            + RandomName("PolynesianSurnames.txt");
                } else {
                    lastName = RandomName("PolynesianSurnames.txt");
                }
            }
            else {
                firstName = RandomName("HispanicFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("HispanicSurnames.txt") + "-"
                            + RandomName("HispanicSurnames.txt");
                } else {
                    lastName = RandomName("HispanicSurnames.txt");
                }
                
            }
            height = RandomHeight("QBHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("QBWeight.txt"));
        } else if (randPosition > 1472 && randPosition <= 1637) {
            position = PlayerPosition.RB;
            int randRace = randomNum.nextInt(165) + 1;
            if (randRace <= 155) {
                firstName = RandomName("AfricanAmericanFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("AfricanAmericanSurnames.txt") + "-"
                            + RandomName("AfricanAmericanSurnames.txt");
                } else {
                    lastName = RandomName("AfricanAmericanSurnames.txt");
                }
            }
            else if (randRace > 155 && randRace <= 159) {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            else if (randRace == 160) {
                firstName = RandomName("PolynesianFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("PolynesianSurnames.txt") + "-"
                            + RandomName("PolynesianSurnames.txt");
                } else {
                    lastName = RandomName("PolynesianSurnames.txt");
                }
            }
            else {
                firstName = RandomName("IgboFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("IgboSurnames.txt") + "-"
                            + RandomName("IgboSurnames.txt");
                } else {
                    lastName = RandomName("IgboSurnames.txt");
                }
            }
            height = RandomHeight("RBHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("RBWeight.txt"));
        } else if (randPosition > 1637 && randPosition <= 1817) {
            position = PlayerPosition.S;
            int randRace = randomNum.nextInt(180) + 1;
            if (randRace <= 153) {
                firstName = RandomName("AfricanAmericanFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("AfricanAmericanSurnames.txt") + "-"
                            + RandomName("AfricanAmericanSurnames.txt");
                } else {
                    lastName = RandomName("AfricanAmericanSurnames.txt");
                }
            }
            else if (randRace > 153 && randRace <= 167) {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            else if (randRace == 168) {
                firstName = RandomName("PolynesianFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("PolynesianSurnames.txt") + "-"
                            + RandomName("PolynesianSurnames.txt");
                } else {
                    lastName = RandomName("PolynesianSurnames.txt");
                }
            }
            else if (randRace > 168 && randRace <= 176) {
                firstName = RandomName("IgboFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("IgboSurnames.txt") + "-"
                            + RandomName("IgboSurnames.txt");
                } else {
                    lastName = RandomName("IgboSurnames.txt");
                }
            }
            else {
                firstName = RandomName("HispanicFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("HispanicSurnames.txt") + "-"
                            + RandomName("HispanicSurnames.txt");
                } else {
                    lastName = RandomName("HispanicSurnames.txt");
                }
            }
            height = RandomHeight("SHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("SWeight.txt"));
        } else if (randPosition > 1817 && randPosition <= 1957) {
            position = PlayerPosition.TE;
            int randRace = randomNum.nextInt(140) + 1;
            if (randRace <= 58) {
                firstName = RandomName("AfricanAmericanFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("AfricanAmericanSurnames.txt") + "-"
                            + RandomName("AfricanAmericanSurnames.txt");
                } else {
                    lastName = RandomName("AfricanAmericanSurnames.txt");
                }
            }
            else if (randRace > 59 && randRace <= 126) {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            else if (randRace > 126 && randRace <= 128) {
                firstName = RandomName("PolynesianFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("PolynesianSurnames.txt") + "-"
                            + RandomName("PolynesianSurnames.txt");
                } else {
                    lastName = RandomName("PolynesianSurnames.txt");
                }
            }
            else if (randRace > 129 && randRace <= 134) {
                firstName = RandomName("IgboFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("IgboSurnames.txt") + "-"
                            + RandomName("IgboSurnames.txt");
                } else {
                    lastName = RandomName("IgboSurnames.txt");
                }
            }
            else {
                firstName = RandomName("HispanicFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("HispanicSurnames.txt") + "-"
                            + RandomName("HispanicSurnames.txt");
                } else {
                    lastName = RandomName("HispanicSurnames.txt");
                }
            }
            height = RandomHeight("TEHeight.txt");
            System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
            System.out.println("Weight: " + RandomHeight("TEWeight.txt"));
        } else {
            position = PlayerPosition.WR;
            int randRace = randomNum.nextInt(244) + 1;
            if (randRace <= 215) {
                firstName = RandomName("AfricanAmericanFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("AfricanAmericanSurnames.txt") + "-"
                            + RandomName("AfricanAmericanSurnames.txt");
                } else {
                    lastName = RandomName("AfricanAmericanSurnames.txt");
                }
            }
            else if (randRace > 216 && randRace <= 239) {
                firstName = RandomName("WhiteFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("WhiteSurnames.txt") + "-"
                            + RandomName("WhiteSurnames.txt");
                } else {
                    lastName = RandomName("WhiteSurnames.txt");
                }
            }
            else if (randRace > 240 && randRace <= 245) {
                firstName = RandomName("IgboFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("IgboSurnames.txt") + "-"
                            + RandomName("IgboSurnames.txt");
                } else {
                    lastName = RandomName("IgboSurnames.txt");
                }
            }
            else {
                firstName = RandomName("HispanicFirstNames.txt");
                if (randHyphenated <= 153) {
                    lastName = RandomName("HispanicSurnames.txt") + "-"
                            + RandomName("HispanicSurnames.txt");
                } else {
                    lastName = RandomName("HispanicSurnames.txt");
                }
            
                }
                height = RandomHeight("WRHeight.txt");
                System.out.println("Height: " + height / 12 + "\'" + height % 12 + "\'\'");
                System.out.println("Weight: " + RandomHeight("WRWeight.txt"));
        }
        if (randSuffix <= 200) {
            if (randWhichSuffix <= 97) 
                lastName += " JR.";
            else if (randWhichSuffix == 100) 
                lastName += " SR.";
            else
                lastName += " III";
         }
        System.out.println(firstName + " " + lastName);
        System.out.println("Position: " + position);
        
        
        System.out.println("Handedness: " + h);
    }

    // produces raw height in inches for player
    private int RandomHeight (String f) throws FileNotFoundException {
        File file = new File(f);
        Scanner sc2 = new Scanner(file);
        Scanner sc3 = new Scanner(file);
        ArrayList<Integer> rarity = new ArrayList<Integer>();
        ArrayList<Integer> height = new ArrayList<Integer>();
        int totalPlayers = 0;
        while (sc2.hasNextLine()) {
            String str = sc2.nextLine();
            height.add(Integer.parseInt(str.substring(0,str.indexOf(":"))));
        }
        while (sc3.hasNextLine()) {
            String str = sc3.nextLine();
            rarity.add(Integer.parseInt(str.substring(str.indexOf(":") + 1, str.length())));
        }

        for (int i = 0; i < rarity.size(); i++) {
            totalPlayers += rarity.get(i);
        }
        Random randomNum = new Random();
        int result = randomNum.nextInt(totalPlayers - 1) + 1;
        int currentSum = 0;
        int raw = 0;
      
        for (int i = 0; i < rarity.size(); i++) {
            currentSum += rarity.get(i);
            if (currentSum - result >= 0 && currentSum - result < rarity.get(i)) {
                raw = height.get(i);
                break;
            }

        }
        sc2.close();
        sc3.close();
        return raw;

    }

    public static void main (String[] args) throws FileNotFoundException {
        Player p = new Player();
        p.RandomPerson();

    }
}