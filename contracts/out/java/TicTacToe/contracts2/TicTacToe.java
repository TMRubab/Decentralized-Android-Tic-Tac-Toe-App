package TicTacToe.contracts2;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.16.
 */
@SuppressWarnings("rawtypes")
public class TicTacToe extends Contract {
    public static final String BINARY = "Bin file was not provided";

    public static final String FUNC_ADDPLAYER = "addPlayer";

    public static final String FUNC_CREATEGAME = "createGame";

    public static final String FUNC_FINISHGAME = "finishGame";

    public static final String FUNC_GETNUMPLAYED = "getNumPlayed";

    public static final String FUNC_GETNUMWIN = "getNumWin";

    public static final String FUNC_JOINGAME = "joinGame";

    public static final String FUNC_LOGIN = "login";

    public static final String FUNC_MOVE = "move";

    public static final Event NEWGAME_EVENT = new Event("NewGame", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event PLAYERJOINEDGAME_EVENT = new Event("PlayerJoinedGame", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    public static final Event PLAYERMADEMOVE_EVENT = new Event("PlayerMadeMove", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected TicTacToe(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TicTacToe(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TicTacToe(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TicTacToe(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<NewGameEventResponse> getNewGameEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NEWGAME_EVENT, transactionReceipt);
        ArrayList<NewGameEventResponse> responses = new ArrayList<NewGameEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NewGameEventResponse typedResponse = new NewGameEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.gameIndex = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.free = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<NewGameEventResponse> newGameEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, NewGameEventResponse>() {
            @Override
            public NewGameEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NEWGAME_EVENT, log);
                NewGameEventResponse typedResponse = new NewGameEventResponse();
                typedResponse.log = log;
                typedResponse.gameIndex = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.free = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<NewGameEventResponse> newGameEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NEWGAME_EVENT));
        return newGameEventFlowable(filter);
    }

    public List<PlayerJoinedGameEventResponse> getPlayerJoinedGameEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PLAYERJOINEDGAME_EVENT, transactionReceipt);
        ArrayList<PlayerJoinedGameEventResponse> responses = new ArrayList<PlayerJoinedGameEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PlayerJoinedGameEventResponse typedResponse = new PlayerJoinedGameEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PlayerJoinedGameEventResponse> playerJoinedGameEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PlayerJoinedGameEventResponse>() {
            @Override
            public PlayerJoinedGameEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PLAYERJOINEDGAME_EVENT, log);
                PlayerJoinedGameEventResponse typedResponse = new PlayerJoinedGameEventResponse();
                typedResponse.log = log;
                typedResponse.name = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PlayerJoinedGameEventResponse> playerJoinedGameEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PLAYERJOINEDGAME_EVENT));
        return playerJoinedGameEventFlowable(filter);
    }

    public List<PlayerMadeMoveEventResponse> getPlayerMadeMoveEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PLAYERMADEMOVE_EVENT, transactionReceipt);
        ArrayList<PlayerMadeMoveEventResponse> responses = new ArrayList<PlayerMadeMoveEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            PlayerMadeMoveEventResponse typedResponse = new PlayerMadeMoveEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.gameIndex = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.row = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.col = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<PlayerMadeMoveEventResponse> playerMadeMoveEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, PlayerMadeMoveEventResponse>() {
            @Override
            public PlayerMadeMoveEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PLAYERMADEMOVE_EVENT, log);
                PlayerMadeMoveEventResponse typedResponse = new PlayerMadeMoveEventResponse();
                typedResponse.log = log;
                typedResponse.gameIndex = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.row = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.col = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<PlayerMadeMoveEventResponse> playerMadeMoveEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PLAYERMADEMOVE_EVENT));
        return playerMadeMoveEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addPlayer(String name, String password) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDPLAYER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(password)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> createGame(BigInteger Len, String password) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATEGAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(Len), 
                new org.web3j.abi.datatypes.Utf8String(password)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> finishGame(BigInteger gameInd, BigInteger winner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_FINISHGAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(gameInd), 
                new org.web3j.abi.datatypes.generated.Int256(winner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getNumPlayed() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETNUMPLAYED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> getNumWin() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETNUMWIN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> joinGame(BigInteger gameInd, String password) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_JOINGAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(gameInd), 
                new org.web3j.abi.datatypes.Utf8String(password)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> login(String name, BigInteger id, String password) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_LOGIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.Utf8String(password)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> move(BigInteger gameInd, BigInteger row, BigInteger col) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_MOVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(gameInd), 
                new org.web3j.abi.datatypes.generated.Uint256(row), 
                new org.web3j.abi.datatypes.generated.Uint256(col)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TicTacToe load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TicTacToe(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TicTacToe load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TicTacToe(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TicTacToe load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TicTacToe(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TicTacToe load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TicTacToe(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class NewGameEventResponse extends BaseEventResponse {
        public BigInteger gameIndex;

        public Boolean free;
    }

    public static class PlayerJoinedGameEventResponse extends BaseEventResponse {
        public String name;
    }

    public static class PlayerMadeMoveEventResponse extends BaseEventResponse {
        public BigInteger gameIndex;

        public BigInteger row;

        public BigInteger col;
    }
}
