package com.example.advnative_project_uts_160418066.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advnative_project_uts_160418066.model.Fasilitas

class DetilFasilitasListViewModel:ViewModel() {
    val FacilitiesLD = MutableLiveData<List<Fasilitas>>()
    val FacilitiesLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun fasilitasGet(jenis:String){
        val listFas:ArrayList<Fasilitas>
        if(jenis=="umum"){
            val fas1 = Fasilitas("Farmasi","https://cms.sehatq.com/public/img/article_img/sama-sama-berinteraksi-dengan-pasien-apa-beda-farmasi-klinis-dan-rumah-sakit-1611133672.jpg")
            val fas2=Fasilitas("Ruang Rawat Inap","https://kih.co.id/wp-content/uploads/2018/03/KIH-Denpasar-Kamar-VIP-A-1.jpg")
            listFas= arrayListOf<Fasilitas>(fas1,fas2)
        }
        else if(jenis=="diagnosa"){
            val fas1 = Fasilitas("BMD","https://www.rsi.co.id/media/k2/items/cache/84c42b9986b8cecdea81ed6abb66c108_XL.jpg")
            val fas2=Fasilitas("CT SCAN","https://pantirapih.or.id/rspr/wp-content/uploads/2021/04/CT-Scan-128-Slice-1536x1156-1-720x380.jpg")
            listFas= arrayListOf<Fasilitas>(fas1,fas2)
        }else{
            val fas1 = Fasilitas("EEG","https://www.verywellhealth.com/thmb/0e22b6CcJAUiE4r_iTUA_nK1Q4Y=/3869x2579/filters:fill(87E3EF,1)/eeg-601235088-5a524fdef1300a0037eeebe5.jpg")
            val fas2=Fasilitas("Cath Lab","https://krakataumedika.com/images/2020/01/cath_lab.jpg")
            listFas= arrayListOf<Fasilitas>(fas1,fas2)
        }
        refresh(listFas)
    }
    
    fun refresh(FasilitasList:ArrayList<Fasilitas>) {
        FacilitiesLD.value = FasilitasList
        FacilitiesLoadErrorLD.value = false
        loadingLD.value = false
    }
}