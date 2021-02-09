import java.util.Arrays;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId;
        String[] domains = {"gmail.com", "live.com"};

        if (speaker.getFirstName() != null && !speaker.getFirstName().trim().equals("")) {
            if (speaker.getLastName() != null && !speaker.getLastName().trim().equals("")) {
                if (speaker.getEmail() != null && !speaker.getEmail().trim().equals("")) {
                    String emailDomain = getEmailDomain(speaker.getEmail()); // outofbound
                    if (Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() == 1) {
                        int exp = speaker.getExp();
                        speaker.setRegistrationFee(calculateFee( exp));
                        try {
                            speakerId = repository.saveSpeaker(speaker);
                        }catch (Exception exception) {
                            throw new SaveSpeakerException("Can't save a speaker.");
                        }
                    } else {
                        throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
                    }
                } else {
                    throw new ArgumentNullException("Email is required.");
                }
            }else {
                throw new ArgumentNullException("Last name is required.");
            }
        } else {
            throw new ArgumentNullException("First name is required.");
        }

        return speakerId;
    }

    public int calculateFee( int exp) {
        int fee = 0;
        if (exp <= 1) {
           fee = 500;
        } else if (exp <= 3) {
            fee = 250;
        } else if (exp >= 4 && exp <= 5) {
            fee = 100;
        } else if (exp >= 6 && exp <= 9) {
            fee = 50;
        }

        return fee;
    }

    public String getEmailDomain(String email) {
        String[] split = email.split("@");
        if(split.length != 2){
            throw new InvalidEmailFormatException("Email format isn't valid");
        }
        return split[1];
    }

}
