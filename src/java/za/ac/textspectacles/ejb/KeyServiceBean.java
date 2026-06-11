package za.ac.textspectacles.ejb;

import javax.ejb.Stateless;
import javax.crypto.SecretKey;
import za.ac.textspectacles.dao.KeyDAO;
import za.ac.textspectacles.util.CryptoUtil;

@Stateless
public class KeyServiceBean {
    private final KeyDAO keyDAO = new KeyDAO();

    public String generateAndStoreKey(String username, String roleName) throws Exception {
        SecretKey key = CryptoUtil.generateKey();
        String keyString = CryptoUtil.keyToString(key);
        keyDAO.saveOrUpdateKey(username, roleName, keyString);
        return keyString;
    }

    public String getKeyForUser(String username) throws Exception {
        return keyDAO.findKeyByUsername(username);
    }

    public String getAnyAgentKey() throws Exception {
        return keyDAO.findAnyAgentKey();
    }
}
