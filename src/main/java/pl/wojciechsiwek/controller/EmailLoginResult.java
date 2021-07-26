package pl.wojciechsiwek.controller;

public enum EmailLoginResult {
    SUCCESS,
    FAILED_BY_CREDENTIALS,
    FAILED_BY_NETWORK,
    FAILED_BY_UNEXPEECTED_ERROR;
}
