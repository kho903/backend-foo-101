package class101.jikim.cpu;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.xml.bind.DatatypeConverter;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HashController {

	@RequestMapping("/hash/{input}")
	public String getDigest(@PathVariable("input") String input) throws NoSuchAlgorithmException {
		for (int i = 0; i < 100_000; i++) {
			input = getMd5Digest(input);
		}
		return input;
	}

	private String getMd5Digest(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(input.getBytes());
		byte[] digest = md.digest();
		String myHash = DatatypeConverter
			.printHexBinary(digest).toUpperCase();
		return myHash;
	}
}
