DESCRIPTION = "Boot partition image"
LICENSE = "MIT"

BOOT_IMAGE_SIZE = "8192"
BOOT_IMAGE_SIZE_raspberrypi2 = "40960"

DEPENDS = "\
	dosfstools-native \
	mtools-native \
"

do_rootfs[depends] += "\
	virtual/bootloader:do_deploy \
"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_install[noexec] = "1"
do_package[noexec] = "1"
do_package_qa[noexec] = "1"
do_packagedata[noexec] = "1"
do_package_write_ipk[noexec] = "1"
do_package_write_deb[noexec] = "1"
do_package_write_rpm[noexec] = "1"

do_rootfs () {
    BOOT_IMAGE=${IMAGE_NAME}.vfat
    BOOTIMG=${DEPLOY_DIR_IMAGE}/${BOOT_IMAGE}

    rm -f ${BOOTIMG}
    mkfs.vfat -S 512 -C ${BOOTIMG} ${BOOT_IMAGE_SIZE}

    for file in ${IMAGE_BOOT_FILES}; do
        mcopy -i ${BOOTIMG} ${DEPLOY_DIR_IMAGE}/${file} ::/
    done
}

do_rootfs_append_raspberrypi2() {
    # Copy board device trees to root folder
    for DTB in ${KERNEL_DEVICE_BLOBS}; do
        DTB_BASE_NAME=`basename ${DTB} .dtb`
        mcopy -i ${BOOTIMG} -s ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${DTB_BASE_NAME}.dtb ::${DTB_BASE_NAME}.dtb
    done

    # Copy device tree overlays to dedicated folder
    mmd -i ${BOOTIMG} overlays
    for DTB in ${KERNEL_DEVICE_OVERLAYS}; do
        DTB_BASE_NAME=`basename ${DTB} .dtb`
        mcopy -i ${BOOTIMG} -s ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${DTB_BASE_NAME}.dtb ::overlays/${DTB_BASE_NAME}.dtb
    done
}

do_rootfs_complete() {
    BOOT_IMAGE=${IMAGE_NAME}.vfat
    BOOTIMG=${DEPLOY_DIR_IMAGE}/${BOOT_IMAGE}

    gzip ${BOOTIMG}
    ln -sf ${BOOT_IMAGE}.gz ${DEPLOY_DIR_IMAGE}/${IMAGE_LINK_NAME}.vfat.gz
}

addtask do_rootfs before do_rootfs_complete
addtask do_rootfs_complete before do_build
