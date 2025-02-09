package org.athlos.core

import com.juul.kable.*;
import kotlinx.coroutines.flow.*

class BluetoothService {

    private var scanner: Scanner? = null
    private var peripheral: Peripheral? = null

    fun startScanning(): Flow<Peripheral> {
        scanner = Scanner()
        return scanner!!.advertisements.map { advertisement ->
            advertisement.peripheral
        }
    }

    suspend fun connectToDevice(peripheral: Peripheral) {
        this.peripheral = peripheral
        peripheral.connect()
    }

    suspend fun readData(serviceUuid: String, characteristicUuid: String): ByteArray {
        val characteristic = peripheral?.services
            ?.find { it.serviceUuid.toString() == serviceUuid }
            ?.characteristics?.find { it.characteristicUuid.toString() == characteristicUuid }

        return characteristic?.read() ?: byteArrayOf()
    }
}
