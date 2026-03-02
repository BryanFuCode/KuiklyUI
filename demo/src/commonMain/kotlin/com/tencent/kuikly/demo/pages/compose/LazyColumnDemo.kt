package com.tencent.kuikly.demo.pages.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tencent.kuikly.compose.ComposeContainer
import com.tencent.kuikly.compose.coil3.rememberAsyncImagePainter
import com.tencent.kuikly.compose.extension.bouncesEnable
import com.tencent.kuikly.compose.foundation.Image
import com.tencent.kuikly.compose.foundation.background
import com.tencent.kuikly.compose.foundation.border
import com.tencent.kuikly.compose.foundation.clickable
import com.tencent.kuikly.compose.foundation.layout.Arrangement
import com.tencent.kuikly.compose.foundation.layout.Box
import com.tencent.kuikly.compose.foundation.layout.Column
import com.tencent.kuikly.compose.foundation.layout.PaddingValues
import com.tencent.kuikly.compose.foundation.layout.Spacer
import com.tencent.kuikly.compose.foundation.layout.fillMaxSize
import com.tencent.kuikly.compose.foundation.layout.fillMaxWidth
import com.tencent.kuikly.compose.foundation.layout.height
import com.tencent.kuikly.compose.foundation.layout.padding
import com.tencent.kuikly.compose.foundation.lazy.LazyColumn
import com.tencent.kuikly.compose.foundation.lazy.grid.GridCells
import com.tencent.kuikly.compose.foundation.lazy.grid.LazyVerticalGrid
import com.tencent.kuikly.compose.foundation.lazy.grid.rememberLazyGridState
import com.tencent.kuikly.compose.foundation.shape.RoundedCornerShape
import com.tencent.kuikly.compose.material3.Card
import com.tencent.kuikly.compose.material3.CardDefaults
import com.tencent.kuikly.compose.material3.Text
import com.tencent.kuikly.compose.setContent
import com.tencent.kuikly.compose.ui.Alignment
import com.tencent.kuikly.compose.ui.Modifier
import com.tencent.kuikly.compose.ui.graphics.Color
import com.tencent.kuikly.compose.ui.text.font.FontWeight
import com.tencent.kuikly.compose.ui.unit.dp
import com.tencent.kuikly.compose.ui.unit.sp
import com.tencent.kuikly.compose.views.Blur
import com.tencent.kuikly.core.annotations.Page
import com.tencent.kuikly.core.log.KLog
import kotlinx.coroutines.launch
import kotlin.random.Random

@Page("LazyColumnDemo")
class LazyColumnDemo : ComposeContainer() {
  override fun willInit() {
    super.willInit()
    setContent {
      ComposeNavigationBar {
        Text(
          text = "LazyColumnDemo",
          fontSize = 18.sp,
          fontWeight = FontWeight.Bold,
          color = Color.Black
        )
        BasicUsageSection()
      }
    }
  }

  @Composable
  private fun BasicUsageSection() {
    Card(
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(12.dp),
      colors = CardDefaults.cardColors(containerColor = Color.White),
      elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
      Column(
        modifier = Modifier.padding(20.dp)
      ) {
        Text(
          text = "🎯 基础用法",
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(bottom = 16.dp).background(Color(0xFF1A1A1A))
        )

        // 基础 LazyColumn 示例
        LazyColumn(
          modifier = Modifier
            .bouncesEnable(false)
            .fillMaxWidth()
            .height(200.dp)
            .background(Color(0xFFE3F2FD))
            .border(2.dp, Color(0xFF2196F3), RoundedCornerShape(8.dp))
            .padding(8.dp),
          verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
          items(10) { index ->
            Box(
              modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFFBBDEFB), RoundedCornerShape(4.dp))
                .padding(horizontal = 12.dp),
              contentAlignment = Alignment.CenterStart
            ) {
              Text(
                text = "列表项 ${index + 1}",
                modifier = Modifier.background(Color(0xFF1976D2)),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
              )
            }
          }
        }
      }
    }
  }

}
